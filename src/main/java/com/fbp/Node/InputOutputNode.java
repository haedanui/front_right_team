package com.fbp.Node;

import com.fbp.Message.Message;
import com.fbp.Wire.Wire;

public abstract class InputOutputNode extends ActiveNode {
    protected Wire[] input;
    protected Wire[] output;

    protected InputOutputNode(String name) {
        this(name, 1, 1);
    }

    protected InputOutputNode(String name, int inCount, int outCount) {
        super(name);

        input = new Wire[inCount];
        output = new Wire[outCount];
    }

    public void connectInputWire(int index, Wire wire) {
        if (0 > index || index >= input.length) throw new IllegalArgumentException("Out of range");

        input[index] = wire;
    }

    public void connectOutputWire(int index, Wire wire) {
        if (0 > index || index >= input.length) throw new IllegalArgumentException("Out of range");

        input[index] = wire;
    }

    public void output(Message message) {
        for (int i = 0; i < output.length; ++i) if (output[i] != null) output[i].put(message);
    }
}
