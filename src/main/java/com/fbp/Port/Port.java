package com.fbp.Port;

import java.util.LinkedList;
import java.util.Queue;

import com.fbp.Message.Message;

public class Port {
    Queue<Message> messageQueue;

    public Port(){
        messageQueue = new LinkedList<>();
    }
    public void put(Message message){
        messageQueue.add(message);
    }

    public boolean hasMessage(){
        return !messageQueue.isEmpty();
    }

    public Message get(){
        //Message messageInfo = messageQueue.poll();
        return messageQueue.poll();
    }
}
