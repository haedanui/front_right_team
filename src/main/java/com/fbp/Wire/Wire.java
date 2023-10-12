package com.fbp.Wire;

import java.util.LinkedList;
import java.util.Queue;

import com.fbp.Message.Message;

public class Wire {
    private Queue<Message> messageQueue;

    public Wire() {
        messageQueue = new LinkedList<>();
    }

    public void put(Message message) {
        messageQueue.add(message);
    }

    public boolean hasMessage() {
        return !messageQueue.isEmpty();
    }

    public Message get() {
        return messageQueue.poll();
    }
}
