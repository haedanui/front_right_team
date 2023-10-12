package com.fbp.Node;

import com.fbp.Exception.IllegalArgumentException;
import com.fbp.Exception.OutOfBoundException;
import com.fbp.Exception.AlreadyExistsException;
import com.fbp.Message.Message;
import com.fbp.Port.Port;

public abstract class InputNode extends ActiveNode{
    protected final Port[] peerPorts;

    protected InputNode(int count, String name){
        super(name);
        if(count<=0){
            throw new IllegalArgumentException();
        }
        peerPorts = new Port[count];
    }
    public void connect(int index, Port port){
        if (peerPorts.length <= index){
            throw new OutOfBoundException();
        }
        if(peerPorts[index]!= null){
            throw new AlreadyExistsException();
        }
        peerPorts[index] = port;
    }

    void output(Message message){
        for(int i = 0; i<peerPorts.length; i++){
            if(peerPorts[i]!=null){
                peerPorts[i].put(message);
            }
        }
    }
    
}
