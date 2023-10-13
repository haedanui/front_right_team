package com.fbp.Node;

import com.fbp.Exception.IllegalArgumentException;
import com.fbp.Wire.Wire;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TraceNode extends ActiveNode {
    Wire[] wires;

    public TraceNode(String name, int count) {
        super(name);
        wires = new Wire[count];
    }


    public void connect(Wire new_Wire,int index) {
        if (wires[index] == null) {
            wires[index] = new_Wire;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    void preprocess() {
    }


    @Override
    void process() {
        for(int i = 0; i < wires.length; i++) {
            if (wires[i] != null) {
                log.trace(String.valueOf(wires[i]));
            }
        }
    }


    @Override
    void postprocess() {

    }

}
