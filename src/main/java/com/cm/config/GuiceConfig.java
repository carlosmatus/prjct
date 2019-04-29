package com.cm.config;


import com.cm.guice.SueldoGuiceModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.guice.annotation.EnableGuiceModules;

@Configuration
@EnableGuiceModules
public class GuiceConfig {

    @Bean
    public SueldoGuiceModule myModule() {
        return new SueldoGuiceModule();
    }
}
