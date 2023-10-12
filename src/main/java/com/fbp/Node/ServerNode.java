package com.fbp.Node;

import java.net.ServerSocket;

import lombok.Getter;

@Getter
public class ServerNode extends ActiveNode {
    private static final int PORT = 8000;
    private static final String HOST = "localhost";

    private ServerSocket server;

    public ServerNode(String name) {
        this(name, PORT);
    }

    public ServerNode(String name, int port) {
        super(name);

        server = new ServerSocket(port);
    }

    @Override
    void process() {

        ServerSocket server = 

    }
    
}
