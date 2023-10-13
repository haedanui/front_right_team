package com.fbp.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.fbp.Message.Message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SocketInNode extends InputNode{
    Socket socket;
    int port;
    BufferedReader reader;
    public SocketInNode(int count, String name, Socket socket, int port){
        super(count, name);
        this.socket = socket;
        this.port = port;
    }
    public SocketInNode(String name, Socket socket, int port){
        super(1, name);
        this.socket = socket;
        this.port = port;
    }

    @Override
    void preprocess() {
        log.info("SocketIn preprocess");
        setInterval(1);
        try{
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    void process() {
        log.info("SocketIn process");
        for(int i = 0; i < getOutputPortLength(); i++){
            if(getOutputPort(i)!=null||getOutputPort(i).hasMessage()){
                Message message = getOutputPort(i).get();
                output(message);
            }
        }
    }

    @Override
    void postprocess() {
        log.info("SocketIn postprocess");
        try{
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
            //throw new UnsupportedOperationException("Unimplemented method 'postprocess'");
        }

    }
    
}
