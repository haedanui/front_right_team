package com.fbp.Message;

import lombok.Getter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Message {
    static int count;
    final String id;
    final long createTime;

    public Message(){
        id = String.format("%s-%04d",getClass().getSimpleName(),count);
        count++;
        log.trace("message create : {}",id);
        createTime = System.currentTimeMillis();
    }
}
