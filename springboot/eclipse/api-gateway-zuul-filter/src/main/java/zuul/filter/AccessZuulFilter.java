package zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AccessZuulFilter extends ZuulFilter{
	
	private Logger logger = LoggerFactory.getLogger(AccessZuulFilter.class);

	@Override
	public Object run() {
		
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		logger.info("send {} request to {}",request.getMethod(), request.getRequestURL());
		
		Object accessToken =request.getParameter("accessToken");
		if(accessToken == null){
			logger.info("accessToken is null");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			return null;
		}
		
		logger.info("accessToken is ok");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "pre"; //
	}

}
