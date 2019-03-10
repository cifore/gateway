package com.csi.sbs.gateway;



import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.csi.sbs.gateway.constant.SysConstant;
import com.csi.sbs.gateway.exception.GatewayException;
import com.csi.sbs.gateway.util.ResultUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class AuthorizedPostFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object run() throws ZuulException {
		// 获取当前请求上下文
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletResponse response = context.getResponse();
		ResultUtil result = new ResultUtil();
		String code = (String) context.get("code");
		String error = (String) context.get("msg");
		//token异常
		if(code!=null && code.equals(String.valueOf(SysConstant.ERROR_CODE403001))){
			result.setCode(code);
			result.setMsg(error);
			
			context.setResponseBody(JSON.toJSONString(result));
			context.setSendZuulResponse(true); // 将请求往后转发
			//context.setResponseStatusCode(Integer.parseInt(code));
			
			throw new GatewayException(Integer.parseInt(code),error);
		}
		context.setSendZuulResponse(true); // 将请求往后转发
		context.setResponseStatusCode(response.getStatus());
		return context;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "post";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 5;
	}

}
