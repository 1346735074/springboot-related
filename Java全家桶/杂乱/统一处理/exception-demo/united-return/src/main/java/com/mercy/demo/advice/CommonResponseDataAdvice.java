package com.mercy.demo.advice;

import com.mercy.demo.annotation.IgnorReponseAdvice;
import com.mercy.demo.vo.ConmmonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一返回包装
 *
 * @author zhaoyao
 * @version 1.0
 * @date 2019-01-26
 */
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {

    @Override
    @SuppressWarnings("all")
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {

        // 检查注解是否存在
        if (methodParameter.getDeclaringClass().isAnnotationPresent(IgnorReponseAdvice.class)){
            return false;
        }

        if (methodParameter.getMethod().isAnnotationPresent(IgnorReponseAdvice.class)){
            return false;
        }

        return true;
    }

    @Nullable
    @Override
    @SuppressWarnings("all")
    public Object beforeBodyWrite(@Nullable Object o,
        MethodParameter methodParameter,
        MediaType mediaType,
        Class<? extends HttpMessageConverter<?>> aClass,
        ServerHttpRequest serverHttpRequest,
        ServerHttpResponse serverHttpResponse) {

        ConmmonResponse<Object> response = new ConmmonResponse<>(0, "");
        if (null == o) {
            return response;
        } else if (o instanceof ConmmonResponse) {
            response = (ConmmonResponse<Object>) o;
        } else {
            response.setData(o);
        }

        return response;
    }
}
