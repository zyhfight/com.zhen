package com.springcloud.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 实现打印请求日志的filter
 * @author: zyh
 * @date: 2018-9-8
 */
public class PreRequestLogFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(PreRequestLogFilter.class);

	/**
	* 返回过滤器类型
	*
	*/
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

	/**
	* 指定过滤器执行顺序
	* 数值越小，优先级越高
	*/
    @Override
    public int filterOrder() {
        //在org.springframework.cloud.netflix.zuul.filters.pre.PreDecorationFilter过滤器前执行
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

	/**
	* true:执行，false：不执行
	*/
    @Override
    public boolean shouldFilter() {
        return true;
    }

	/**
	* 过滤器具体逻辑
	*/
    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        PreRequestLogFilter.LOGGER.info("send {} request to {}", request.getMethod(), String.valueOf(request.getRequestURL()));

        return null;
    }
}
