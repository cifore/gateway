package com.csi.sbs.gateway.exception;

import com.netflix.zuul.exception.ZuulException;

@SuppressWarnings("serial")
public class GatewayException extends ZuulException {

	public GatewayException(int code, String message) {
		super(message, code, message);
	}


}
