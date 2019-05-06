package com.imooc.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * TokenFilter
 */
@Component
public class TokenFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //拦截类型
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        //是否拦截
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //实现的逻辑
        RequestContext requestContext=RequestContext.getCurrentContext();
        HttpServletRequest request=requestContext.getRequest();

        //url参数里获取
        String token = request.getParameter("token");
        if(StringUtils.isEmpty(token)){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());//返回401
        }
        return null;
    }
}
