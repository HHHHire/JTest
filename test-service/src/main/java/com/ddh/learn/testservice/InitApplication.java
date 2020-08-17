package com.ddh.learn.testservice;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author: dengdh@dist.com.cn
 * @data: 2020/8/17 15:49
 */
public class InitApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TestServiceApplication.class);
    }
}
