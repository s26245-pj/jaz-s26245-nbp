package com.example.jazs26245nbp.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggConfig {

    @Bean
    public OpenAPI apiDocConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("NBP GOLD RATES API")
                        .description("Restful service for getting Gold Rates from NBP API")
                        .version("0.1")
                        .contact(new Contact()
                                .name("Author")
                                .email("26245@pjwstk.edu.pl")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentation")
                        .url("https://gakko.pjwstk.edu.pl/"));

    }

}
