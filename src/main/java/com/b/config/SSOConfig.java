package com.b.config;

import com.b.sso.SSOInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration//配置类，包含一个或多个被@bean注解的方法，这些方法被扫描后初始化spring容器
public class SSOConfig implements WebMvcConfigurer {
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SSOInterceptor())
                .addPathPatterns("/student/**","/teacher/**")//拦截路径
                .excludePathPatterns("/login");//不拦截的路径
    }

}
