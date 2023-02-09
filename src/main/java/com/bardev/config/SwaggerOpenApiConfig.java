package com.bardev.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition
public class SwaggerOpenApiConfig {

    @Bean
    public OpenAPI springAgendaServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Spring Developers Bar Service")
                        .description("Spring Developers Bars service application")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Spring Developers Bar Wiki Documentation")
                        .url("https://github.com/felipematheus1337/BarDev-s_Microsservice"));
    }





}
