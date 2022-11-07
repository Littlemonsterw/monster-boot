package com.monster.common.config;

import io.swagger.annotations.Api;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.CorsEndpointProperties;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.boot.actuate.autoconfigure.web.server.ManagementPortType;
import org.springframework.boot.actuate.endpoint.ExposableEndpoint;
import org.springframework.boot.actuate.endpoint.web.*;
import org.springframework.boot.actuate.endpoint.web.annotation.ControllerEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.annotation.ServletEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.servlet.WebMvcEndpointHandlerMapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Swagger2 API文档的配置
 *
 * @author wuhan
 * @date 2022/9/26 10:44
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .groupName("base")
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Monster项目API文档")
                .description("monster-project-api")
                .contact(new Contact("monster", "", ""))
                .version("1.0.0")
                .build();
    }

    /**
     * 解决不兼容问题
     */
    @Bean
    public WebMvcEndpointHandlerMapping handlerMapping(WebEndpointsSupplier webSupplier,
                                                       ServletEndpointsSupplier servletSupplier,
                                                       ControllerEndpointsSupplier controllerSupplier,
                                                       EndpointMediaTypes mediaTypes,
                                                       CorsEndpointProperties corsProperties,
                                                       WebEndpointProperties webProperties,
                                                       Environment environment) {

        List<ExposableEndpoint<?>> allEndpoints = new ArrayList<>();
        Collection<ExposableWebEndpoint> webEndpoints = webSupplier.getEndpoints();
        allEndpoints.addAll(webSupplier.getEndpoints());
        allEndpoints.addAll(servletSupplier.getEndpoints());
        allEndpoints.addAll(controllerSupplier.getEndpoints());
        String basePath = webProperties.getBasePath();
        EndpointMapping mapping = new EndpointMapping(basePath);
        boolean flag = registerLinkMapping(webProperties, environment, basePath);
        return new WebMvcEndpointHandlerMapping(mapping, webEndpoints, mediaTypes, corsProperties.toCorsConfiguration(),
                new EndpointLinksResolver(allEndpoints, basePath),
                flag, null);
    }

    private boolean registerLinkMapping(WebEndpointProperties properties, Environment environment, String basePath) {
        return properties.getDiscovery().isEnabled()
                && (StringUtils.hasText(basePath) || ManagementPortType.get(environment).equals(ManagementPortType.DIFFERENT));
    }
}