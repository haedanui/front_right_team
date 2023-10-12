package com.fbp.Node;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import com.fbp.Request;
import com.fbp.Wire.Wire;

import lombok.extern.slf4j.Slf4j;

// TODO add log, 값 입력, 출력은 테스트를 위한 임시 코드입니다.
@Slf4j
public class ClientNode extends InputOutputNode {
    private static final String HOST = "localhost";
    private static final int PORT = 8000;

    private String host;
    private int port;
    private Socket socket;
    private OutputStream outputStream;
    private InputStream inputStream;

    public ClientNode(String name) {
        this(name, HOST, PORT);
    }

    public ClientNode(String name, String host, int port) {
        super(name);

        this.port = port;
        this.host = host;
    }

    @Override
    void preprocess() {
        try {
            socket = new Socket(host, port);

            outputStream = socket.getOutputStream();
            inputStream = socket.getInputStream();

            Thread messageReceiver = new Thread(() -> {
                while (!Thread.currentThread().interrupted()) {
                    try {
                        var br = new BufferedReader(new InputStreamReader(inputStream));
                        System.out.println(br.readLine());
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });

            messageReceiver.start();
        } catch (Exception e) {
        }
    }

    @Override
    void postprocess() {
        try {
            if (socket == null) return;

            socket.close();
            socket = null;
        } catch (Exception e) {
        }
    }

    @Override
    void process() {
        var br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String rawRequest = br.readLine();
            Request request = new Request(rawRequest);

            // wrapping message;
            // send.
            
        } catch (Exception e) {
        }
    }
}
