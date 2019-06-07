package com.momo.springboot.exception;

/**
 * @author momo
 * @create 2019-06-07 下午 14:01
        */
public class UserNotExistException extends RuntimeException{

    public UserNotExistException() {
        super("用户不存在");
    }
}
