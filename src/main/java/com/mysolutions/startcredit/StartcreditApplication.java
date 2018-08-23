package com.mysolutions.startcredit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.mysolutions.startcredit"})
@EntityScan(basePackages = {"com.mysolutions.startcredit"})
@ComponentScan(basePackages = {"com.mysolutions.startcredit"})
@PropertySource("classpath:application.properties")
public class StartcreditApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartcreditApplication.class, args);
    }
}
