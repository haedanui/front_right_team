package com.fbp.Node;

import java.util.Scanner;

import com.fbp.Message.*;

public class StandardInNode extends InputNode{
    Scanner scanner;
    public StandardInNode(int count, String name){
        super(count, name);
    }
    public StandardInNode(String name){
        super(1, name);
    }
    @Override
    void preprocess() {
        scanner = new Scanner(System.in);
        setInterval(1);
    }

    @Override
    void process() {
        String line = scanner.nextLine();
        Message m = new StringMessage(line);
        StringMessage message = (StringMessage) m;
        output(message);
    }

    @Override
    void postprocess() {
        scanner.close();
    }
    
}
