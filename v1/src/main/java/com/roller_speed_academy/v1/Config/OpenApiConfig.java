package com.roller_speed_academy.v1.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Configuración de OpenAPI para la documentación de la API
 * Aplica el principio de Responsabilidad Única (SRP) - SOLID
 * Esta clase se encarga únicamente de la configuración de la documentación
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Roller Speed Academy API")
                        .version("1.0.0")
                        .description("API REST para la gestión de la academia de patinaje Roller Speed. " +
                                "Proporciona operaciones CRUD para la administración de usuarios y servicios de la academia.")
                        .contact(new Contact()
                                .name("Equipo de Desarrollo Roller Speed")
                                .email("contacto@rollerspeed.com")
                                .url("https://github.com/Wilgarle/Roller_speed"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("Servidor de Desarrollo Local"),
                        new Server()
                                .url("https://api.rollerspeed.com")
                                .description("Servidor de Producción (Futuro)")
                ));
    }
}
