package com.chloe.curd.crud.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: SwaggerConfig
 * Package: com.chloe.curd.crud.config
 * Description:
 *
 * @Author Xu, Luqin
 * @Create 2024/11/6 14:11
 * @Version 1.0
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi deptApi() {
        return GroupedOpenApi.builder()
                .group("springshop-dept")
                .pathsToMatch("/dept/**")
                .build();
    }
    @Bean
    public GroupedOpenApi empApi() {
        return GroupedOpenApi.builder()
                .group("springshop-emp")
                .pathsToMatch("/emp/**")
//                .addMethodFilter(method -> method.isAnnotationPresent(Admin.class))
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("SpringShop API")
                        .description("Spring shop sample application")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"));
    }
}
