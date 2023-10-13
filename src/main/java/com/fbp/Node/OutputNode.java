package com.fbp.Node;

import com.fbp.Exception.AlreadyExistsException;
import com.fbp.Exception.OutOfBoundException;
import com.fbp.Message.Message;
import com.fbp.Port.Port;

public abstract class OutputNode extends ActiveNode{
    protected Port[] inputPorts;

    public OutputNode(int count, String name){
        super(name);
        if(count<=0){
            throw new IllegalArgumentException();
        }
        inputPorts = new Port[count];
        
    }
    public OutputNode(String name){
        super(name);
        inputPorts = new Port[1];
    }
    protected void connect(int index, Port port){
        if(inputPorts.length < index){
            throw new OutOfBoundException();
        }
        if(inputPorts[index]!= null){
            throw new AlreadyExistsException();
        }
        inputPorts[index] = port;
    }
    protected int getInputPortLength(){
        return inputPorts.length;
    }
    protected Port getInputPort(int index){
        return inputPorts[index];
    }
    void output(Message message){
        for(int i = 0; i<inputPorts.length; i++){
            if(inputPorts[i]!=null){
                inputPorts[i].put(message);
            }
        }
    }

    
}
