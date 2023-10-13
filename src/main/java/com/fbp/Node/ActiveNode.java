package com.fbp.Node;

import lombok.Getter;

@Getter
public abstract class ActiveNode extends Node implements Runnable {
    protected long startTime;
    protected Thread thread;
    protected long interval = 1_000;

    protected ActiveNode(String name) {
        super(name);

        thread = new Thread(this, name);
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public void start() {
        startTime = System.currentTimeMillis();

        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }

    abstract void preprocess();

    abstract void process();

    abstract void postprocess();

    public void run() {
        preprocess();

        long previousTime = startTime;
        while (!Thread.currentThread().isInterrupted()) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - previousTime;

            if (interval > elapsedTime) {
                try {
                    process();
                    Thread.sleep(interval - elapsedTime);
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            }

            previousTime = startTime + (System.currentTimeMillis() - startTime) / interval * interval;
        }

        postprocess();
    }
}
