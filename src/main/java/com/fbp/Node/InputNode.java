package com.fbp.Node;

import com.fbp.Exception.IllegalArgumentException;
import com.fbp.Exception.OutOfBoundException;
import com.fbp.Exception.AlreadyExistsException;
import com.fbp.Message.Message;
import com.fbp.Port.Port;

public abstract class InputNode extends ActiveNode{
    protected final Port[] outputPorts;

    protected InputNode(int count, String name){
        super(name);
        if(count<=0){
            throw new IllegalArgumentException();
        }
        outputPorts = new Port[count];
    }
    public void connect(int index, Port port){
        if (outputPorts.length <= index){
            throw new OutOfBoundException();
        }
        if(outputPorts[index]!= null){
            throw new AlreadyExistsException();
        }
        outputPorts[index] = port;
    }
    public int getOutputPortLength(){
        return outputPorts.length;
    }
    public Port getOutputPort(int count){
        return outputPorts[count];
    }

    void output(Message message){
        for(int i = 0; i<outputPorts.length; i++){
            if(outputPorts[i]!=null){
                outputPorts[i].put(message);
            }
        }
    }
    
}