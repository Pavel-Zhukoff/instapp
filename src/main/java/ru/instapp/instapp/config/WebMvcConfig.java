package ru.instapp.instapp.config;

//import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
    //@Value("${upload.path}")
    //private String uploadPath;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/img/**")
        //        .addResourceLocations("file://" + uploadPath + "/");
        registry.addResourceHandler("/style/**")
                .addResourceLocations("classpath:/static/");
    }

}
