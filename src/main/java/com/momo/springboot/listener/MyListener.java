package com.momo.springboot.listener;

import javax.servlet.Servlet;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author momo
 * @create 2019-06-07 上午 1:39
 */
public class MyListener implements ServletContextListener{
        @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized....web被启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextInitialized....web被销毁");
    }
}
