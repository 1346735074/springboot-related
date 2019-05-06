package com.example.config;

import com.example.entity.MiaoshaUser;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by nuonuo
 * 2018/8/22 下午 5:39
 */
@Service
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    /**
     * 验证是否执行
     *
     * @param methodParameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        Class<?> aClass = methodParameter.getParameterType();
        return aClass == MiaoshaUser.class;//判断是否为MiaoshaUser类
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse response = nativeWebRequest.getNativeResponse(HttpServletResponse.class);

        String paramToken = request.getParameter("");
        String cookieToken = request.getParameter("");
        return new MiaoshaUser("小明", "123");
    }
}
