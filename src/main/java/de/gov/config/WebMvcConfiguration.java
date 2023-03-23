package de.gov.config;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ServletComponentScan
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

	Logger logger = LogManager.getLogger(MybatisConfiguration.class);
    public WebMvcConfiguration() {
        logger.info("createConfing:WebMvcConfiguration");

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOriginPatterns("*")
                .maxAge(3600);
    }
}
