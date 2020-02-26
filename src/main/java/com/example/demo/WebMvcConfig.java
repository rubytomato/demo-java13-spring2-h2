package com.example.demo;

import com.example.demo.controller.BaseBackendInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
  private final BaseBackendInterceptor baseBackendInterceptor;

  public WebMvcConfig(BaseBackendInterceptor baseBackendInterceptor) {
    this.baseBackendInterceptor = baseBackendInterceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(baseBackendInterceptor).addPathPatterns("/account/**");
  }
}
