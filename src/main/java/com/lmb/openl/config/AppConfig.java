package com.lmb.openl.config;

import com.lmb.openl.service.IRuleExtractor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

/**
 * Created by n0292928 on 11/5/16.
 */

@Configuration
@ComponentScan(basePackageClasses ={ IRuleExtractor.class, AppConfig.class})
@PropertySource( value={"classpath:application.properties"}, ignoreResourceNotFound = false)
public class AppConfig {

    @Value("${lmb.openl.rule.pathFileName}")
    public String       rulesPathFileName;

    public String getRulesPathFileName() {  return rulesPathFileName;  }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
