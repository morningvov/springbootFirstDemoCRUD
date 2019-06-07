package com.momo.springboot.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author momo
 * @create 2019-06-04 上午 1:23
 * 登录检查
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //在目标方法调用之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if(user == null){
            //未登录，则返回登录页面
            request.setAttribute("msg","权限不够，请先登录");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else{
            //已登录，则放行请求
            return true;
        }
    }
}
