package com.fbp.Node;

import java.util.Scanner;

import javax.management.monitor.StringMonitor;

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
        StringMessage message = new StringMessage(line);
        output(message);
    }

    @Override
    void postprocess() {
        scanner.close();
    }
    
}
