package com.rk.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.rk.annoations.PassToken;
import com.rk.annoations.UserLoginToken;
import com.rk.dataobject.User;
import com.rk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by nuonuo
 * 2018/8/9 下午 4:57
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    /*预处理回调方法,实现处理器的预处理*/
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object object) throws Exception {
//        1.从 http 请求头中取出 token，
//        2.判断是否映射到方法
//        3.检查是否有passtoken注释，有则跳过认证
//        4.检查有没有需要用户登录的注解，有则需要取出并验证
//        5.认证通过则可以访问，不通过会报相关错误信息

        // 从 http 请求头中取出 token
        String token = httpServletRequest.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();

        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    throw new RuntimeException("无token，请重新登录");
                }
            }
            // 获取 token 中的 user id
            String userId;
            try {
                userId = JWT.decode(token).getAudience().get(0);
            } catch (JWTDecodeException e) {
                throw new RuntimeException("401");
            }

            User user = userService.findUserById(userId);
            if (user == null) {
                throw new RuntimeException("用户不存在，请重新登录");
            }
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
            try {
                jwtVerifier.verify(token);
            } catch (JWTVerificationException e) {
                throw new RuntimeException("401");
            }
            return true;
        }
        return true;
    }

    /*后处理回调方法，实现处理器的后处理*/
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    /*整个请求处理完毕回调方法*/
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}
