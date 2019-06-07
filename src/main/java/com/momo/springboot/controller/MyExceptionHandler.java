package com.momo.springboot.controller;

import com.momo.springboot.exception.UserNotExistException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author momo
 * @create 2019-06-07 下午 13:56
 */
@ControllerAdvice
public class MyExceptionHandler {

//        @ResponseBody
//        @ExceptionHandler(UserNotExistException.class)
//        public Map<String,Object> handleException(Exception e){
//            Map<String,Object> map = new HashMap<>();
//            map.put("code","user.notexist");
//            map.put("message",e.getMessage());
//            return map;
//        }
        //自适应
        @ExceptionHandler(UserNotExistException.class)
        public String handleException(Exception e, HttpServletRequest request){
            Map<String,Object> map = new HashMap<>();
            request.setAttribute("javax.servlet.error.status_code",500);
            map.put("code","user.notexist");
            map.put("message","用户不存在的呀");
            request.setAttribute("ext",map);
            return "forward:/error";
        }
}
