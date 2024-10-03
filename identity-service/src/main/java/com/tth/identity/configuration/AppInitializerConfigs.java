package com.tth.identity.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class AppInitializerConfigs {

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            log.info("Initializing application.....");

            // TODO: Implement initialization logic here

            log.info("Application initialization completed.....");
        };
    }

}
