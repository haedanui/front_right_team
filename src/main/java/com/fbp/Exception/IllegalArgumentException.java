package com.fbp.Exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IllegalArgumentException extends RuntimeException{
    static final String s = "count가 0보다 작습니다.";
    public IllegalArgumentException(){
        log.warn(s);
    }
}
