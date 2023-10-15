package com.fbp.Node;

import com.fbp.Exception.IllegalArgumentException;
import com.fbp.Wire.Wire;

import lombok.extern.slf4j.Slf4j;

/*
 * exception을 처리할 수 있다는 말의 뜻을 모름
 * 익셉션을 트레이스 노드에서 다룬다?
 * 익셉션을 트레이스 노드에서 출력한다?
 */

@Slf4j
public class TraceNode extends ActiveNode {
    Wire[] wires;

    public TraceNode(String name, int count) {
        super(name);
        wires = new Wire[count];
    }

    public void connect(Wire wire, int index) {
        if (wires[index] == null) {
            wires[index] = wire;
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
            if (wires[i] != null && wires[i].hasMessage()) {
                log.trace(wires[i].get().toString());
            }
        }
    }

    @Override
    void postprocess() {

    }

}
