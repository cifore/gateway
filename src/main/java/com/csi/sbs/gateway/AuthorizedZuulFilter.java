package com.csi.sbs.gateway;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netflix.zuul.context.RequestContext;

import io.jsonwebtoken.Claims;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.csi.sbs.common.business.util.JwtTokenProviderUtil;
import com.csi.sbs.gateway.constant.SysConstant;
import com.csi.sbs.gateway.model.PermissionModel;
import com.csi.sbs.gateway.util.PostUtil;
import com.netflix.zuul.ZuulFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

public class AuthorizedZuulFilter extends ZuulFilter {

	@Resource
	private RestTemplate restTemplate;
	
	private JwtTokenProviderUtil jwtToken = new JwtTokenProviderUtil("123456");

	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(AuthorizedZuulFilter.class);

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
		return 1;
	}

	/**
	 * 是否启用Filter
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public RequestContext run() {
		// 获取当前请求上下文
		RequestContext context = RequestContext.getCurrentContext();
		// 获取原始Http请求
		HttpServletRequest request = context.getRequest();
		String path = request.getServletPath();
		//忽略不需要请求头的请求
		if(SysConstant.getNoNeedHeaderUrl().contains(path)){
			context.setSendZuulResponse(true); // 将请求往后转发
			context.setResponseStatusCode(200);
			return context;
		}
		
		// 获取用户ID
		String userID = request.getHeader("userID");
		// 获取国家代码
		String countryCode = request.getHeader("countryCode");
		// 获取银行代码
		String clearingCode = request.getHeader("clearingCode");
		// 获取分行代码
		String branchCode = request.getHeader("branchCode");
		// 获取客户身份证号码
		String customerID = request.getHeader("customerID");
		// 获取token
		String token = request.getHeader("token");
		
		//校验访问接口时是否登录
		if(!SysConstant.getLoginUrl().contains(path)){
			if(StringUtils.isEmpty(customerID) || StringUtils.isEmpty(token)){
				HttpServletResponse response = context.getResponse();
				response.setHeader("Content-Type", "application/json;charset=UTF-8");
				//response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
				context.setSendZuulResponse(false); // 终止转发，返回响应报文
				context.setResponseStatusCode(400);
				Map<String, String> responseMap = new HashMap<String, String>();
				responseMap.put("errorcode", "400");
				responseMap.put("errormsg", "请求被拦截-没有登录");
				context.setResponseBody(JSON.toJSONString(responseMap));
				return context;
			}
			//校验token所包含的customerID 是否是传进来的customerID
			Claims userClaims = jwtToken.parseToken(token);
			if(!customerID.equals(userClaims.get("customerID"))){
				HttpServletResponse response = context.getResponse();
				response.setHeader("Content-Type", "application/json;charset=UTF-8");
				//response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
				context.setSendZuulResponse(false); // 终止转发，返回响应报文
				context.setResponseStatusCode(400);
				Map<String, String> responseMap = new HashMap<String, String>();
				responseMap.put("errorcode", "400");
				responseMap.put("errormsg", "请求被拦截-无权限");
				context.setResponseBody(JSON.toJSONString(responseMap));
				return context;
			}
		}
		if (!StringUtils.isEmpty(userID)) {
			PermissionModel permission = new PermissionModel();
			permission.setUserID(userID);
			permission.setCountryCode(countryCode);
			permission.setClearingCode(clearingCode);
			permission.setBranchCode(branchCode);
			ResponseEntity<String> result = restTemplate.postForEntity(SysConstant.PERMISSION_URL,
					PostUtil.getRequestEntity(JSON.toJSONString(permission)), String.class);
			JSONObject rejson = JSON.parseObject(result.getBody());
			JSONObject rejsondata = JSON.parseObject(rejson.get("data").toString());
			if (result.getStatusCodeValue() == 200 && rejson.get("code").equals("1")) {
				context.addZuulRequestHeader("userID", userID);
				context.addZuulRequestHeader("countryCode", rejsondata.get("countryCode").toString());
				context.addZuulRequestHeader("clearingCode", rejsondata.get("clearingCode").toString());
				context.addZuulRequestHeader("branchCode", rejsondata.get("branchCode").toString());
				context.addZuulRequestHeader("customerID", customerID);
			
				context.setSendZuulResponse(true); // 将请求往后转发
				context.setResponseStatusCode(200);
				return context;
			}else{
				HttpServletResponse response = context.getResponse();
				response.setHeader("Content-Type", "application/json;charset=UTF-8");
				//response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
				context.setSendZuulResponse(false); // 终止转发，返回响应报文
				context.setResponseStatusCode(400);
				Map<String, String> responseMap = new HashMap<String, String>();
				responseMap.put("errorcode", "400");
				responseMap.put("errormsg", "请求被拦截-无权限");
				context.setResponseBody(JSON.toJSONString(responseMap));
				return context;
			}
		} else {
			HttpServletResponse response = context.getResponse();
			if (request.getMethod().equals("OPTIONS")) {
				response.setStatus(HttpServletResponse.SC_OK);
				response.setHeader("Content-Type", "application/json;charset=UTF-8");
				context.setSendZuulResponse(true); // 将请求往后转发
				context.setResponseStatusCode(200);
				return context;
	        }
			response.setHeader("Content-Type", "application/json;charset=UTF-8");
			context.setSendZuulResponse(false); // 终止转发，返回响应报文
			context.setResponseStatusCode(400);
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("errorcode", "400");
			responseMap.put("errormsg", "请求被拦截-请求头缺失userID");
			context.setResponseBody(JSON.toJSONString(responseMap));
			return context;
		}
	}
}
