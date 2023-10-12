package com.fbp.Exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OutOfBoundException extends RuntimeException{
    static final String s = "count 가 index값의 범위를 벗어났습니다.";
    public OutOfBoundException(){
        log.warn(s);
    }
}
