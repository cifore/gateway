package com.csi.sbs.gateway.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.csi.sbs.gateway.constant.SysConstant;
import com.csi.sbs.gateway.util.ResultUtil;



@Controller
public class ErrorHandlerController implements ErrorController{

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/error")
	@ResponseBody
    public String error(HttpServletRequest request,HttpServletResponse response) {
		ResultUtil result = new ResultUtil();
		result.setCode(SysConstant.ERROR_CODE1);
		result.setMsg("token is exception,please contact administrator");
		
		response.setHeader("Access-Control-Allow-Origin:", "*");
		
        return JSON.toJSONString(result);
    }


}
