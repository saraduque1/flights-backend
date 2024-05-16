package com.udea.Flights;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Flight API documentation")
                        .version("1.0")
                        .description("This is the documentation for the Flight Search System.")
                        .contact(new Contact()
                                .name("Sara Duque")
                                .email("sara@udea.com")
                                .url("https://flights.com")));
    }
}

