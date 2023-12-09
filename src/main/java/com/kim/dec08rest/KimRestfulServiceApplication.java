package com.kim.dec08rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
}
