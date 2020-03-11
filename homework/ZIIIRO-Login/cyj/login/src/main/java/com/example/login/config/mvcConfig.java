package com.example.login.config;

import com.example.login.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class mvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login/log").setViewName("international");
    }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }

}
