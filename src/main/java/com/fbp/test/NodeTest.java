package com.fbp.test;

import com.fbp.Node.StandardInNode;
import com.fbp.Node.StandardOutNode;
import com.fbp.Port.Port;

public class NodeTest {
    public static void main(String[] args) {
        StandardInNode in = new StandardInNode("in");
        StandardOutNode out = new StandardOutNode("out");

        Port port = new Port();

        in.connect(0,port);
        out.connect(0, port);

        in.start();
        out.start();
    }
}
