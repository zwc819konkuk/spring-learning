package com.zwc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.zwc")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfig {
}
