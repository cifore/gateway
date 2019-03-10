package com.csi.sbs.gateway;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netflix.zuul.context.RequestContext;

import io.jsonwebtoken.Claims;

import com.alibaba.fastjson.JSON;
import com.csi.sbs.common.business.util.JwtTokenProviderUtil;
import com.csi.sbs.gateway.constant.SysConstant;
import com.csi.sbs.gateway.exception.AuthorizedException;
import com.csi.sbs.gateway.exception.GatewayException;
import com.csi.sbs.gateway.model.HeaderModel;
import com.netflix.zuul.ZuulFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

public class AuthorizedPreFilter extends ZuulFilter {

	@Resource
	private RestTemplate restTemplate;

	private JwtTokenProviderUtil jwtToken = new JwtTokenProviderUtil("123456");

	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(AuthorizedPreFilter.class);

	/**
	 * <b>Filter类型</b>
	 * <li>PRE： 这种过滤器在请求被路由之前调用。我们可利用这种过滤器实现身份验证、在集群中选择请求的微服务、记录调试信息等。
	 * <li>ROUTING：这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服务的请求，并使用Apache
	 * HttpClient或Netfilx Ribbon请求微服务。
	 * <li>POST：这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的HTTP
	 * Header、收集统计信息和指标、将响应从微服务发送给客户端等。
	 * <li>ERROR：在其他阶段发生错误时执行该过滤器。
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 优先级
	 * <p>
	 * 定义filter的顺序，数字越小表示顺序越高，越优先执行
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/**
	 * 是否启用Filter
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public RequestContext run() throws GatewayException, AuthorizedException {
		// 获取当前请求上下文
		RequestContext context = RequestContext.getCurrentContext();
		// 获取原始Http请求
		HttpServletRequest request = context.getRequest();
		HttpServletResponse response = context.getResponse();
		String path = request.getServletPath();
		// 校验Web前端发送预检请求
		if (request.getMethod().equals("OPTIONS")) {
			response.setStatus(HttpServletResponse.SC_OK);
			response.setHeader("Content-Type", "application/json;charset=UTF-8");
			context.setSendZuulResponse(true); // 将请求往后转发
			context.setResponseStatusCode(200);
			return context;
		}
		// 忽略不需要登录的请求(Url 不带参数)
		if (SysConstant.getNoNeedLoginOne().contains(path)) {
			context.setSendZuulResponse(true); // 将请求往后转发
			context.setResponseStatusCode(200);
			return context;
		}
		// 忽略不需要登录的请求(Url 带参数)
		for (int i = 0; i < SysConstant.getNoNeedLoginTwo().size(); i++) {
			if (SysConstant.getNoNeedLoginTwo().get(i).indexOf(path) != -1) {
				context.setSendZuulResponse(true); // 将请求往后转发
				context.setResponseStatusCode(200);
				return context;
			}
		}
		// 获取token
		String token = request.getHeader("token");
		// 解密token
		Claims userClaims = jwtToken.parseToken(token);
		
		String userID = (String) userClaims.get("developerID");
		String countryCode = (String) userClaims.get("countryCode");
		String clearingCode = (String) userClaims.get("clearingCode");
		String branchCode = (String) userClaims.get("branchCode");
		String customerNumber = (String) userClaims.get("customerNumber");
		String loginName = (String) userClaims.get("loginName");
		
		//拿到clientid
		//String clientid =request.getHeader("clientid");
		//将clientid 和 解密的比对
//		if(!clientid.equals(loginName)){
//			context.addZuulRequestHeader("code", String.valueOf(SysConstant.ERROR_CODE403002));
//			throw new AuthorizedException(SysConstant.ERROR_CODE403002,"No permissions");
//		}

		HeaderModel header = new HeaderModel();
		header.setCountryCode(countryCode);
		header.setClearingCode(clearingCode);
		header.setBranchCode(branchCode);
		header.setUserID(userID);
		header.setLoginName(loginName);
		header.setCustomerNumber(customerNumber);
		// 校验是否登录
		if (StringUtils.isEmpty(token)) {
			// 调用未登录方法
			return noLogin(context, request);
		}
		return loginValidate(context, request, header);
	}

	/**
	 * 无权限
	 */
	@SuppressWarnings("unused")
	private RequestContext noPermission(RequestContext context, HttpServletRequest request) {
		HttpServletResponse response = context.getResponse();
		response.setHeader("Content-Type", "application/json;charset=UTF-8");
		context.setSendZuulResponse(false); // 终止转发，返回响应报文
		context.setResponseStatusCode(400);
		Map<String, String> responseMap = new HashMap<String, String>();
		responseMap.put("errorcode", String.valueOf(SysConstant.ERROR_CODE403002));
		responseMap.put("errormsg", "No permissions");
		context.setResponseBody(JSON.toJSONString(responseMap));
		return context;
	}

	/**
	 * 登录后处理
	 */
	private RequestContext loginValidate(RequestContext context, HttpServletRequest request, HeaderModel header) {
		context.addZuulRequestHeader("developerID", header.getUserID());
		context.addZuulRequestHeader("countryCode", header.getCountryCode());
		context.addZuulRequestHeader("clearingCode", header.getClearingCode());
		context.addZuulRequestHeader("branchCode", header.getBranchCode());
		context.addZuulRequestHeader("customerNumber", header.getCustomerNumber());
		context.addZuulRequestHeader("loginName", header.getLoginName());

		context.setSendZuulResponse(true); // 将请求往后转发
		context.setResponseStatusCode(200);
		return context;
	}

	/**
	 * 没有登录
	 */
	private RequestContext noLogin(RequestContext context, HttpServletRequest request) {
		HttpServletResponse response = context.getResponse();
		response.setHeader("Content-Type", "application/json;charset=UTF-8");
		context.setSendZuulResponse(false); // 终止转发，返回响应报文
		context.setResponseStatusCode(400);
		Map<String, String> responseMap = new HashMap<String, String>();
		responseMap.put("errorcode", String.valueOf(SysConstant.ERROR_CODE403003));
		responseMap.put("errormsg", "No login");
		context.setResponseBody(JSON.toJSONString(responseMap));
		return context;
	}
	

}
