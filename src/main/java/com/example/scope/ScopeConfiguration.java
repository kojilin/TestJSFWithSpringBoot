package com.example.scope;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScopeConfiguration {

    @Bean
    public CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer csc = new CustomScopeConfigurer();
        csc.addScope("view", new ViewScope());
        return csc;
    }
}
