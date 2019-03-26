//package com.csi.sbs.gateway;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger.web.UiConfiguration;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo());
//    }
//
//    @SuppressWarnings("deprecation")
//	private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("SBS")
//                .description("SBS接口文档说明")
//                .termsOfServiceUrl("http://localhost:8089")
//                .contact("Pim li:lihuacheng@chinasofti.com")
//                .version("1.0")
//                .build();
//    }
//
//    @SuppressWarnings("deprecation")
//	@Bean
//    UiConfiguration uiConfig() {
//        return new UiConfiguration(null, "list", "alpha", "schema",
//                UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, false, true, 60000L);
//    }
//}
