package com.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"dev","stag","prod"})
public class ProfileConfig {

    @Bean
    public EnvConfiguration getEnvConfigurationImpl(){
        return new EnvConfigurationImpl();
    }
}