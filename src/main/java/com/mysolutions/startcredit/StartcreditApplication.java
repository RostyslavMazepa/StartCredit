package com.mysolutions.startcredit;

import com.mysolutions.startcredit.entity.Role;
import com.mysolutions.startcredit.entity.User;
import com.mysolutions.startcredit.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.mysolutions.startcredit"})
@EntityScan(basePackages = {"com.mysolutions.startcredit"})
@ComponentScan(basePackages = {"com.mysolutions.startcredit"})
@PropertySource("classpath:application.properties")
public class StartcreditApplication {

    @Bean
    public CommandLineRunner setupDefaultUser(UserService userService) {
        return args -> {
            userService.save(new User(
                    "rostyslav.mazepa@gmail.com", //username
                    "MaRo210583", //password
                    Arrays.asList(new Role("USER"), new Role("ACTUATOR")), //roles
                    true //Active
            ));
        };

    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(StartcreditApplication.class, args);
    }
}
