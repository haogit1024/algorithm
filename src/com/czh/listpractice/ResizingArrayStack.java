package com.czh.listpractice;

import java.util.Iterator;

/**
 * 数组实现stack
 */
public class ResizingArrayStack<Item>  {
    private Item[] a = (Item[]) new Object[10];
    //表示下一个元素加入的位置,所以该位置一直是空
    private int N = 0;

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item) {
        if (N == a.length) {
            resize(a.length * 2);
        }
        a[N++] = item;
    }

    public Item pop() {
        if (N <= a.length / 4) {
            resize(a.length / 2);
        }
        Item item = a[--N];
        return item;
    }

    public static void main(String[] args) throws InterruptedException {
        ResizingArrayStack<Object> stack = new ResizingArrayStack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        stack.push("7");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("------------");
        System.out.println(stack.N);
        Thread.sleep(2000);
        System.out.println(stack.a.length);
    }
}
