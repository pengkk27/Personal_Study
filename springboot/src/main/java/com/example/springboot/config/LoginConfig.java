package com.example.springboot.config;

import com.example.springboot.interceptor.AdminLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new AdminLoginInterceptor());
        registration.addPathPatterns("/**");
        registration.excludePathPatterns(
                "/adminLogin",
                "/css/**",
                "/js/**",
                "/**/*.html",
                "/login",
                "/userLogin",
                "/userRegister",
                "/userUpdateInfo",
                "/getUserById",
                "/text_process/**"
        );
    }

}