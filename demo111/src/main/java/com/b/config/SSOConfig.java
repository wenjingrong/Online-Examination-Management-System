package com.b.config;

import com.b.sso.SSOInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SSOConfig implements WebMvcConfigurer {
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SSOInterceptor())
                .addPathPatterns("/student/**","/teacher/**")
                .excludePathPatterns("/login");
    }

}
