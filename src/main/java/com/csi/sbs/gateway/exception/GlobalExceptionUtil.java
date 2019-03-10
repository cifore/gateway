package com.csi.sbs.gateway.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.csi.sbs.gateway.util.Result;

import org.springframework.http.HttpStatus;


@ControllerAdvice
public class GlobalExceptionUtil {
	
	//private static Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(value = GatewayException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Result handleResourceGateException(GatewayException e)
    {
        return new Result(e.getMessage(), e.nStatusCode);
    }
    
    @ExceptionHandler(value = AuthorizedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Result handleResourceAuthorException(AuthorizedException e)
    {
        return new Result(e.getMessage(), e.nStatusCode);
    }
	
}
