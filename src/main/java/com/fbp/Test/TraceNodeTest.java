package com.fbp.Test;

import com.fbp.Message.Message;
import com.fbp.Node.TraceNode;
import com.fbp.Wire.Wire;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TraceNodeTest {
    public static void main(String[] args) {
        Wire wire = new Wire();
        Message msg = new Message();
        wire.put(msg);
        TraceNode traceNode = new TraceNode("TraceNode", 3);
        traceNode.connect(wire, 0);
        traceNode.run();
    }
}
