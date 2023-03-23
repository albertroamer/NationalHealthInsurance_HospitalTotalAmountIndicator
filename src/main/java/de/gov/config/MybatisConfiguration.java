package de.gov.config;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan("de.gov.dao")
public class MybatisConfiguration {
	
	Logger logger = LogManager.getLogger(MybatisConfiguration.class);
	
	
    public MybatisConfiguration() {
        logger.info("createConfing:MybatisConfiguration");

    }
    
  
}
