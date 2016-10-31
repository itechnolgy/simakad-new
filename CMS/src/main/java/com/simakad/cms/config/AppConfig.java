package com.simakad.cms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * Created by SRIN on 9/21/2016.
 */
@Configuration
@Import({DatabaseConfig.class, SecurityConfig.class, ThymeleafConfig.class, WebAppConfig.class})
@PropertySource("classpath:/application-dev.properties")
public class AppConfig {
    // this is for multipart file
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        return resolver;
    }

    //this is for get props value for annotation @Value
    @Bean
    public PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
