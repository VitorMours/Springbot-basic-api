package com.webserver.diorailway;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@OpenAPIDefinition(servers ={ @Server(url = "/", description="default url")})
@SpringBootApplication
public class DiorailwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiorailwayApplication.class, args);
    }





}
