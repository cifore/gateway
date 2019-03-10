package com.csi.sbs.gateway.exception;

import com.netflix.zuul.exception.ZuulException;

@SuppressWarnings("serial")
public class AuthorizedException extends ZuulException {

	public AuthorizedException(int code, String message) {
		super(message, code, message);
	}

}
