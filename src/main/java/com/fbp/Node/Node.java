package com.fbp.Node;

import java.util.UUID;

import ch.qos.logback.classic.Logger;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public abstract class Node {
    static int count;
    // final String id;
    String name;
    Logger logger;
    UUID id;

    public Node(){
        count++;
        //id = String.format("%s-%02d", getClass().getSimpleName(),count);
        id = UUID.randomUUID();
        log.trace("create node : {}", id);

    }
    public abstract void setName(String name);
}
