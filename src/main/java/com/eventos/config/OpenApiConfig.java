package com.eventos.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI eventosOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Sistema de Gestión de Eventos - API REST")
                        .description("API para crear, listar, actualizar y eliminar eventos. Desarrollada con Spring Boot, PostgreSQL y JPA.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Kevin Domínguez")
                                .url("https://github.com/Dominguezkev")));
    }
}
