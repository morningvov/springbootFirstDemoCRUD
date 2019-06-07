package com.momo.springboot.controller;

import com.momo.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

/**
 * @author momo
 * @create 2019-06-02 下午 19:29
 */
@Controller
public class HelloController {

//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "index";
//    }
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "Hello World!";
    }

    @RequestMapping("/success")
    public String testThymeleaf(Map<String,Object> maps){
        maps.put("hello","<h1>你好</h1>");
        maps.put("users", Arrays.asList("zhang","lishi","wang"));
        return "success";
    }

}
