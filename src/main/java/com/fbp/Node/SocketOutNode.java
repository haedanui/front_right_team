package com.fbp.Node;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

import com.fbp.Message.Message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SocketOutNode extends OutputNode{
    Socket socket;
    BufferedWriter writer;
    int port;
    public SocketOutNode(int count, String name, Socket socket, int port){
        super(count, name);
        this.socket = socket;
        this.port = port;
    }
    public SocketOutNode(String name, Socket socket, int port){
        super(name);
        this.socket = socket;
        this.port = port;
    }
    @Override
    void preprocess() {
        log.info("SocketOut preprocess");
        setInterval(1);
        try {
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void process() {
        log.info("SocketOut process");
        for(int i = 0; i < getInputPortLength(); i++){
            if(getInputPort(i)!=null||getInputPort(i).hasMessage()){
                Message message = getInputPort(i).get();
                try {
                    writer.write(message.toString());
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    void postprocess() {
        log.info("SocketOut postprocess");
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
