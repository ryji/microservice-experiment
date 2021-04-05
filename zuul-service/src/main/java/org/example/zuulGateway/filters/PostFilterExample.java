package org.example.zuulGateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostFilterExample extends ZuulFilter {

    private static final int FILTER_ORDER = 1;
    private static final boolean SHOULD_FILTER=true;
    private static final Logger logger = LoggerFactory.getLogger(PostFilterExample.class);

    @Autowired
    FilterUtils filterUtils;

    @Override
    public String filterType() {
        return FilterUtils.POST_FILTER_TYPE;
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        logger.debug("begin post-filter for {} , corId is {}."
                , ctx.getRequest().getRequestURI(), filterUtils.getCorrelationId());
        String corId = filterUtils.getCorrelationId();
        logger.debug("adding correlation-id to outbound headers.{}", corId);

        ctx.getResponse().addHeader(FilterUtils.CORRELATION_ID, corId);
        logger.debug("completed outgoing request for {}, corId is {}", ctx.getRequest().getRequestURI(), corId);
        return null;
    }
}
