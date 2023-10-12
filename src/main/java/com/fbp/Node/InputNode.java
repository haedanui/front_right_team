package com.fbp.Node;

import com.fbp.Message.Message;
import com.fbp.Port.Port;

public class InputNode extends ActiveNode{
    private final Port[] peerPorts;

    public InputNode(int count){
        super();
        if(count<=0){
            //TODO 예왜이럼 처리
        }
        peerPorts = new Port[count];
    }
    public void connect(int index, Port port){
        if (count <= index){

        }
        if(peerPorts[index]!= null){

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
