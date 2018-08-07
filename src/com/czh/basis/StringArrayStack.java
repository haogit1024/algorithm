package com.czh.basis;

public class StringArrayStack {
    private String[] array;
    private int length = 0;
    public StringArrayStack(int size) {
        array = new String[size];
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int size() {
        return length;
    }

    public void push(String val) {
        array[length++] = val;
    }

    public String pop() {
        return array[--length];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("this is null");
            return;
        }
        System.out.println("size:" + length);
        for (String s : array) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        StringArrayStack stack = new StringArrayStack(10);
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        stack.push("f");
        stack.push("g");
        stack.push("h");
        stack.push("i");
        stack.push("j");
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());
    }
}
