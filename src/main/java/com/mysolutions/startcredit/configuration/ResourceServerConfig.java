package com.mysolutions.startcredit.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .headers()
                .frameOptions()
                .disable()
                .and()
                .authorizeRequests()
                .antMatchers(
                        "/",
                        "/home",
                        "/register",
                        "/login",
                        "/day-weather").permitAll()
                .antMatchers(
                        "/private/**",
                        "/document/**",
                        "/documents/**",
                        "/documenttype/**",
                        "/documenttypes/**",
                        "/person/**",
                        "/persons/**",
                        "/personrelation/**",
                        "/personrelations/**",
                        "/phone/**",
                        "/phones/**",
                        "/phonetype/**",
                        "/phonetype/**",
                        "/relationtype/**",
                        "/relationtype/**"
                ).authenticated();
    }
}
