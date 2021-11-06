package org.example.azure.storeage.queue.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${api.version}")
    private String apiVersion;

    @Value("${api.description}")
    private String apiDescription;

    @Value("${api.title}")
    private String apiTitle;

    @Value("${swagger.config.api.basepackage}")
    private String basePackage;

    @Value("${swagger.config.api.path}")
    private String swaggerPath;

    @Bean
    public Docket productApi() {
        ArrayList<ResponseMessage> responseMessages = new ArrayList<>();
        responseMessages.add(new ResponseMessageBuilder().code(400).message("Bad Request")
                .responseModel(new ModelRef("Error")).build());
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(regex(swaggerPath)).build().globalResponseMessage(RequestMethod.POST, responseMessages);
    }
}
