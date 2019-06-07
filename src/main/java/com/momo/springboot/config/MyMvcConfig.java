package com.momo.springboot.config;

import com.momo.springboot.component.LoginHandlerInterceptor;
import com.momo.springboot.component.MyLocaleResolver;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author momo
 * @create 2019-06-03 下午 16:12
 */

//public class MyMvcConfig implements WebMvcConfigurer {
@Configuration
public class MyMvcConfig implements WebMvcConfigurer{

    //    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//
//        registry.addViewController("/momo").setViewName("success");
//        registry.addViewController("/").setViewName("index");
//        registry.addViewController("/index").setViewName("index");
//    }

    //起始页面，首页（视图控制器）
    @Bean
    public WebMvcConfigurer mvcMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {

                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册登录权限拦截器（拦截资源，放行）
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/","/index.html","/user/login","/asserts/**","/webjars/**","/favicon.ico");
//            }
        };
        return webMvcConfigurer;
    }

    //注册Locale解析器,使默认的Locale失效（默认的是通过请求头来解析区域信息）
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }


}



