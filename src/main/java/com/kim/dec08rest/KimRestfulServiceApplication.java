package com.kim.dec08rest;

import org.apache.tomcat.util.descriptor.LocalResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class KimRestfulServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KimRestfulServiceApplication.class, args);

        //       ApplicationContext ac = SpringApplication.run(KimRestfulServiceApplication.class, args);
//
//       String[] allBeanNames = ac.getBeanDefinitionNames();
//       for (String beanNames : allBeanNames) {
//           System.out.println(beanNames);
//       }
    }

    @Bean
    public LocaleResolver localResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);
        return sessionLocaleResolver;
    }
}
