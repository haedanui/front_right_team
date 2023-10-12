package com.fbp.Node;

import ch.qos.logback.classic.Logger;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public abstract class Node {
    static int count;
    final String id;
    String name;
    Logger logger;

    public Node(){
        count++;
        id = String.format("%s-%02d", getClass().getSimpleName(),count);
        log.trace("create node : {}", id);

    }
    public abstract void setName(String name);
}
