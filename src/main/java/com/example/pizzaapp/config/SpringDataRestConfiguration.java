package com.example.pizzaapp.config;

import com.example.pizzaapp.web.rest.processor.PizzaProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDataRestConfiguration {

    @Bean
    public PizzaProcessor pizzaProcessor() {
        return new PizzaProcessor();
    }
}
