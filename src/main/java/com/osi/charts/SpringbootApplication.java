package com.osi.charts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.osi.charts")
public class SpringbootApplication{

    public static void main(String[] args) throws Exception{
        SpringApplication.run(SpringbootApplication.class, args);
    }
}

