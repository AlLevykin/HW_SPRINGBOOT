package ru.netology.springBootDemo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.springBootDemo.repository.DevProfile;
import ru.netology.springBootDemo.repository.ProductionProfile;
import ru.netology.springBootDemo.repository.SystemProfile;

@Configuration
public class SpringBootDemoConfig {
    @Bean
    @ConditionalOnProperty(name = "netology.profile.dev",
            havingValue = "true")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(name = "netology.profile.dev",
            matchIfMissing=true,
            havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
