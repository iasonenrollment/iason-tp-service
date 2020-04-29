package com.iason.trading.partner.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: OpenApiConfig
 * Inside the package - com.iason.trading.partner.config
 * Created Date: 4/29/2020
 * Created Time: 4:07 PM
 **/
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customConfiguration(){
        List<Server> serverList = new ArrayList<>();
        serverList.add(new Server().url("http://localhost:8080").description("Development Server"));
        serverList.add(new Server().url("http://qa.iason-tp-service.com").description("QA Server"));
        serverList.add(new Server().url("http://prod.iason-tp-service.com").description("Production Server"));
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Iason Trading Partner Microservice")
                        .description("API Documentation for Iason Trading Partner Service")
                        .version("1.0.0")
                        .contact(new Contact().email("vbalaji215@gmail.com").url("http://iason.com")))
                .servers(serverList);
    }
}
