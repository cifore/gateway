package com.csi.sbs.gateway.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;



public class PostUtil {
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static HttpEntity<String> getRequestEntity(String json) {
		// headers
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		// httpEntity
		HttpEntity requestEntity = new HttpEntity(json, requestHeaders);
		
		return requestEntity;
	}

}
