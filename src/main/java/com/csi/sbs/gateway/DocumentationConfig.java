//package com.csi.sbs.gateway;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.cloud.netflix.zuul.filters.Route;
//import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;
//
//import springfox.documentation.swagger.web.SwaggerResource;
//import springfox.documentation.swagger.web.SwaggerResourcesProvider;
//
//@Component
//@Primary
//public class DocumentationConfig implements SwaggerResourcesProvider{
//	
//	private final RouteLocator routeLocator;
//
//    public DocumentationConfig(RouteLocator routeLocator) {
//    this.routeLocator = routeLocator;
//    }
//
//    @SuppressWarnings({ })
//	@Override
//    public List<SwaggerResource> get() {
//    	 @SuppressWarnings("rawtypes")
//		List resources = new ArrayList<>();
//         resources.add(swaggerResource("Hello接口", "/swagger.json", "1.0"));
//         resources.add(swaggerResource("检查系统接口", "/swagger.json", "1.0"));
//         return resources;
//    }
//
//     private SwaggerResource swaggerResource(String name, String location, String version) {
//            SwaggerResource swaggerResource = new SwaggerResource();
//            swaggerResource.setName(name);
//            swaggerResource.setLocation(location);
//            swaggerResource.setSwaggerVersion(version);
//            return swaggerResource;
//     }
//}