package com.csi.sbs.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;



@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
@CrossOrigin// 解决跨域请求
public class Application {
	
	
	@Bean
	public AuthorizedZuulFilter sessionPreFilter() {
		return new AuthorizedZuulFilter();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

