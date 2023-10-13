package com.fbp.Node;

import com.fbp.Message.Message;
import com.fbp.Message.StringMessage;

public class StandardOutNode extends OutputNode{
    public StandardOutNode(int count, String name){
        super(count, name);
    }
    public StandardOutNode(String name){
        super(name);
    }
    @Override
    void preprocess() {
        setInterval(1);
    }

    @Override
    void process() {
        for(int i = 0; i < getInputPortLength(); i++){
            if(getInputPort(i).hasMessage()){
                Message message = getInputPort(i).get();
                if(message instanceof StringMessage){
                    System.out.println(((StringMessage)message).getPayload());
                }else{
                    message.toString();
                }
            }
        }
    }

    @Override
    void postprocess() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postprocess'");
    }
    
}
