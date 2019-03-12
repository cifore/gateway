package com.csi.sbs.gateway.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csi.sbs.gateway.constant.SysConstant;
import com.csi.sbs.gateway.exception.GatewayException;


@CrossOrigin // 解决跨域请求
@Controller
public class ErrorHandlerController implements ErrorController{

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@RequestMapping("/error")
	@ResponseBody
    public String error(HttpServletRequest request,HttpServletResponse response) throws NumberFormatException, GatewayException {
		throw new GatewayException(SysConstant.ERROR_CODE403001,"token exception,please contact administrator");
    }


}
