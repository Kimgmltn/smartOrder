package com.smartorder;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@OpenAPIDefinition(info = @Info(title="smartOrder APIs", version = "1.0", description = "스마트 오더 APIs"))
public class SmartorderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartorderApplication.class, args);
    }

}
