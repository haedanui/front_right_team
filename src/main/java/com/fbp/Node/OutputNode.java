package com.fbp.Node;

import com.fbp.Exception.AlreadyExistsException;
import com.fbp.Exception.OutOfBoundException;
import com.fbp.Port.Port;

public abstract class OutputNode extends ActiveNode{
    protected Port[] inputPorts;

    protected OutputNode(int count, String name){
        super(name);
        if(count<=0){
            throw new IllegalArgumentException();
        }
        inputPorts = new Port[count];
        
    }
    protected OutputNode(String name){
        super(name);
        inputPorts = new Port[1];
    }
    public void connect(int index, Port port){
        if(inputPorts.length < index){
            throw new OutOfBoundException();
        }
        if(inputPorts[index]!= null){
            throw new AlreadyExistsException();
        }
        inputPorts[index] = port;
    }
    public int getInputPortLength(){
        return inputPorts.length;
    }
    public Port getInputPort(int index){
        if (index < 0 || inputPorts.length <= index) {
            throw new OutOfBoundException();
        }

        return inputPorts[index];
    }

    
}
