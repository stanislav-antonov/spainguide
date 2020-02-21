package com.pse.spainguide.configuration;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private FileStorageConfiguration fileStorageConfiguration;

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin").setViewName("admin-spa/index");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path = fileStorageConfiguration.getNormalizedBasePath().toUri().toString();
        registry.addResourceHandler("/file-storage/**").addResourceLocations(path);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
    }
}