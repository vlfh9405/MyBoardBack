package com.example.myboard.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Configuration
public class ImageWebConfig implements WebMvcConfigurer {

    @Value("${webImgLocation}")
    private String webImgLocation;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String uploadDir = Paths.get(webImgLocation).toUri().toString();

        registry.addResourceHandler("/images/**")
                .addResourceLocations("/"+uploadDir);
    }

}

