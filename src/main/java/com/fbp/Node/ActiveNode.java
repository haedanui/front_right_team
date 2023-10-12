package com.fbp.Node;

import lombok.Getter;

@Getter
public abstract class ActiveNode extends Node implements Runnable {
    String name;
    Thread thread;
    long startTime;
    long interval = 1000;

    public ActiveNode() {
        super();
        thread = new Thread(this, getId().toString());
    }

    public ActiveNode(String name) {
        super();
        thread = new Thread(this, name);
    }

    @Override
    public void setName(String name) {
        thread.setName(name);
    }

    @Override
    public String getName() {
        return thread.getName();
    }
    public void setInterval(int index){
        interval = index;
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        thread.isInterrupted();
    }

    void preprocess() {

    }

    void process() {

    }

    void postprocess() {

    }

    public void run() {
        preprocess();
        startTime = System.currentTimeMillis();
        long previousTime = startTime;
        while (!Thread.currentThread().isInterrupted()) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - previousTime;
            if (interval > elapsedTime) {
                try {
                    process();
                    Thread.sleep(interval = elapsedTime);
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            }
            previousTime = startTime + (System.currentTimeMillis() - startTime) / interval * interval;
        }
        postprocess();
    }

}
