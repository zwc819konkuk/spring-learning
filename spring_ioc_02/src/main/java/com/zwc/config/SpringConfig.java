package com.zwc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = "com.zwc")
@PropertySource("classpath:a.properties")
public class SpringConfig {
}
