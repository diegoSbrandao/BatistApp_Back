package com.apprest.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.apprest")).paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }

    private ApiInfo apiInfo() {
        return new ApiInfo("APIREST AppBatist", "Documentação da API"
                + ".", "v1",
                "https://github.com/DSB88/BatistApp", new Contact("Diego Brandão",
                "https://www.linkedin.com/in/diego-brand%C3%A3o-dev", "diego.brandao@outlook.com"),
                "License of API", "License of URL", Collections.emptyList());
    }
}