package com.yun.yscdzullservice.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 前置过滤器
@Component
public class TrackingFilter extends ZuulFilter {
    private static final int FILTER_ORDER = 1;
    private static final boolean SHOULD_FILTER = true;
    private static final Logger logger = LoggerFactory.getLogger(TrackingFilter.class);

    // 辅助类
    @Autowired
    FilterUtils filterUtils;

    // ---过滤器方法

    // 过滤器类型
    @Override
    public String filterType() {
        return FilterUtils.PRE_FILTER_TYPE;
    }

    // 不同类型过滤器的执行顺序
    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    // 是否执行过滤
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    // run
    public Object run() {
        if (isCorrelationIdPresent()) { // 有 id
            logger.debug("tmx-correlation-id found in tracking filter: {}. ", filterUtils.getCorrelationId());
        } else {
            filterUtils.setCorrelationId(generateCorrelationId());
            logger.debug("tmx-correlation-id generated in tracking filter: {}.", filterUtils.getCorrelationId());
        }

        RequestContext ctx = RequestContext.getCurrentContext();
        logger.debug("Processing incoming request for {}.", ctx.getRequest().getRequestURI());

        return null;
    }

    // ---私有方法

    private boolean isCorrelationIdPresent() {
        if (filterUtils.getCorrelationId() != null) {
            return true;
        }

        return false;
    }

    private String generateCorrelationId() {
        return java.util.UUID.randomUUID().toString();
    }

}