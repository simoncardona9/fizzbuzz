package com.intraway.fizzbuzz.configuration;

import com.intraway.fizzbuzz.service.FizzBuzzService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/intraway/api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(FizzBuzzService.class);
    }
}
