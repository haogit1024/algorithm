package com.czh;

import java.util.Stack;

/**
 * Created by czh on 17-8-7.
 */
public class Test {
    public Test(){
        display();
    }

    public void display(){
        System.out.println("aaaaa");
    }

    public static void main(String[] args) {
        Test t = new Test();
    }
    static class Node {
        String a;
        public Node(String a) {
            this.a = a;
        }
    }
}
