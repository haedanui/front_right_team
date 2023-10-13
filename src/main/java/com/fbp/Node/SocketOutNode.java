package com.fbp.Node;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

import com.fbp.Message.Message;

public class SocketOutNode extends OutputNode{
    Socket socket;
    BufferedWriter writer;
    public SocketOutNode(int count, String name, Socket socket){
        super(count, name);
        this.socket = socket;
    }
    public SocketOutNode(String name, Socket socket){
        super(name);
        this.socket = socket;
    }
    @Override
    void preprocess() {
        setInterval(1);
        try {
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void process() {
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
        try {
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
