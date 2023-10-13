package com.fbp.test;

import java.io.IOException;
import java.net.Socket;

import com.fbp.Node.SocketInNode;
import com.fbp.Node.SocketOutNode;

public class SocketTest {
    public static void main(String[] args) {
        int port = 7797;
        try {
            Socket socket = new Socket("localhost", port);
            SocketInNode reader = new SocketInNode("in", socket, port);
            SocketOutNode writer = new SocketOutNode("out", socket, port);

            writer.run();
            reader.run();

        } catch (IOException e) {
            e.getStackTrace();
        }

    }

}
