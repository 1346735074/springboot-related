package com.imooc.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.imooc.exception.RateLimitException;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * 限流
 */
@Component
public class RateLimitFilter extends ZuulFilter {

    private static final RateLimiter RATE_LIMITER=RateLimiter.create(100);//谷歌令牌桶

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //如果没有拿到令牌
        if (!RATE_LIMITER.tryAcquire()){
            throw new RateLimitException();
        }
        return null;
    }
}
