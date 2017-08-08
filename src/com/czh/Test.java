package com.czh;

import java.util.Stack;

/**
 * Created by czh on 17-8-7.
 */
public class Test {
    public static void main(String[] args) {
        Node a = new Node("fuck");
        Node b = a;
        a = new Node("fucking");
        System.out.println(b.a);
    }
    static class Node {
        String a;
        public Node(String a) {
            this.a = a;
        }
    }
}
