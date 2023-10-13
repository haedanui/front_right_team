package com.fbp.Node;

import com.fbp.Message.Message;

public class SocketInNode extends InputNode{

    public SocketInNode(int count, String name){
        super(count, name);
    }
    public SocketInNode(String name){
        super(1, name);
    }

    @Override
    void preprocess() {
        setInterval(1);
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postprocess'");
    }
    
}
