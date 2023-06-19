package com.master.caps.configurer;

import com.master.caps.interceptor.LoginInterceptor;
import com.master.caps.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebAppConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/error")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/js/*")
                .excludePathPatterns("/img/*")
                .excludePathPatterns("/font/*")
                .excludePathPatterns("/webfonts/*");
    }


}
