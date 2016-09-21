package com.simakad.cms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by SRIN on 9/21/2016.
 */
@Configuration
@Import({DatabaseConfig.class, SecurityConfig.class, ThymeleafConfig.class, WebAppConfig.class})
@PropertySource("classpath:/application-dev.properties")
public class AppConfig {
}
