package org.example.zuulGateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PreFilterExample extends ZuulFilter {
    private static final int FILTER_ORDER = 1;
    private static final boolean SHOULD_FILTER=true;
    private static final Logger logger = LoggerFactory.getLogger(PreFilterExample.class);

    @Autowired
    FilterUtils filterUtils;

    @Override
    public String filterType() {
        return FilterUtils.PRE_FILTER_TYPE;
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
        logger.debug("begin pre-filter for {}", ctx.getRequest().getRequestURI());

        if (filterUtils.getCorrelationId() != null){
            logger.debug("correlation-id found: {}.", filterUtils.getCorrelationId());
        }
        else{
            filterUtils.setCorrelationId(UUID.randomUUID().toString());
            logger.debug("correlation-id generated: {}.", filterUtils.getCorrelationId());
        }
        logger.debug("begin route incoming request for {} , corId is {}."
                , ctx.getRequest().getRequestURI(), filterUtils.getCorrelationId());
        return null;
    }
}
