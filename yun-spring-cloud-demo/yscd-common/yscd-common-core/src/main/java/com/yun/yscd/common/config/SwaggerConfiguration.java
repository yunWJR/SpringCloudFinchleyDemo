package com.yun.yscd.common.config;

import com.google.common.net.HttpHeaders;
import com.yun.yscd.common.config.properties.SwaggerProperties;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: yun
 * @createdOn: 2019-05-07 10:33.
 */

@EnableSwagger2
public class SwaggerConfiguration {
    @Resource
    private YscdProperties properties;

    /**
     * Reservation api docket.
     * @return the docket
     */
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
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .enable(properties.getSwagger().getEnable());
    }

    private ApiInfo apiInfo() {
        SwaggerProperties swagger = properties.getSwagger();
        return new ApiInfoBuilder()
                .title(swagger.getTitle())
                .description(swagger.getDescription())
                .version(swagger.getVersion())
                .license(swagger.getLicense())
                .licenseUrl(swagger.getLicenseUrl())
                .contact(new Contact(swagger.getContactName(), swagger.getContactUrl(), swagger.getContactEmail()))
                .build();
    }
}
