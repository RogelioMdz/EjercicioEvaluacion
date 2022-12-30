package com.libertyf.ejercicioevaluacion.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket apiDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis((Predicate<RequestHandler>) RequestHandlerSelectors.basePackage("com.libertyf.ejercicioevaluacion.controller"))
                .paths((Predicate<String>) PathSelectors.any())
                .build();
    }
}
/**
 * DOCUMENTATION SWAGGER
 * https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
 *
 */
