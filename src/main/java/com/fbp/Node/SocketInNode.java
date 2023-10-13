package com.fbp.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.fbp.Message.Message;

public class SocketInNode extends InputNode{
    Socket socket;
    BufferedReader reader;
    public SocketInNode(int count, String name, Socket socket){
        super(count, name);
        this.socket = socket;
    }
    public SocketInNode(String name, Socket socket){
        super(1, name);
        this.socket = socket;
    }

    @Override
    void preprocess() {
        setInterval(1);
        try{
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    void process() {
        for(int i = 0; i < getOutputPortLength(); i++){
            if(getOutputPort(i)!=null||getOutputPort(i).hasMessage()){
                Message message = getOutputPort(i).get();
                output(message);
            }
        }
    }

    @Override
    void postprocess() {
        try{
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
            //throw new UnsupportedOperationException("Unimplemented method 'postprocess'");
        }

    }
    
}
