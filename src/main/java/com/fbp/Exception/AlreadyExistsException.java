package com.fbp.Exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlreadyExistsException extends RuntimeException{
    static final String s = "배열에 이미 값이 있습니다.";
    public AlreadyExistsException(){
        log.warn(s);
    }
}
