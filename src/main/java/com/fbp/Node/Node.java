package com.fbp.Node;

import java.time.OffsetDateTime;
import java.util.UUID;

import ch.qos.logback.classic.Logger;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public abstract class Node {
    private static int nodeCount;

    protected final UUID id;
    protected final OffsetDateTime createdDate;
    protected String name;
    protected Logger logger;

    protected Node(String name) {
        nodeCount++;

        createdDate = OffsetDateTime.now();
        id = UUID.randomUUID();
        this.name = name;

        log.trace("create node : {}", id);
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getNodeCount() {
        return nodeCount;
    }
}
