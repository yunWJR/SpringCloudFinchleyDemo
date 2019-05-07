package com.yun.yscd.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yun
 * @createdOn: 2019-05-07 09:39.
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        List<Parameter> operationParameters = new ArrayList<Parameter>();

        ParameterBuilder tokenBd = new ParameterBuilder();
        tokenBd.name(HttpHeaders.AUTHORIZATION)
                .description("登录后的token，有则填")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        operationParameters.add(tokenBd.build());

        ParameterBuilder deviceTypeBuilder = new ParameterBuilder();
        deviceTypeBuilder.name("deviceType")
                .description("1-iOS、2-Android 3-Pc 4-WeChat")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true)
                .build();

        operationParameters.add(deviceTypeBuilder.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(operationParameters)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yun.yscdserviceuser"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("晟堃科技接口文档")
                .description("报销管理系统管理端")
                // .termsOfServiceUrl("com.skteh.epmgapi")
                // .contact("CGW")
                .version("1.0")
                .build();
    }
}