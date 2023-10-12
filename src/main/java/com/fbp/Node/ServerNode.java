package com.fbp.Node;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Handler;

import lombok.Getter;

@Getter
public class ServerNode extends ActiveNode {
    private static final int PORT = 8000;
    private static final String HOST = "localhost";

    private ServerSocket server = null;
    private int port;

    public ServerNode(String name) {
        this(name, PORT);
    }

    public ServerNode(String name, int port) {
        super(name);

        this.port = port;
    }

    @Override
    public void preprocess() {
        try {
            server = new ServerSocket(port);
        } catch (Exception e) {
        }
    }

    @Override
    void process() {
        try {
            Socket socket = server.accept();
        } catch (Exception e) {
        }
    }

    @Override
    void postprocess() {
        try {
            if (server == null) return;

            server.close();
            server = null;
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
}
