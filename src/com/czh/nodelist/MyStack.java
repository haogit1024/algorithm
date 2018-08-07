package com.czh.nodelist;

/**
 * 使用链表实现stack
 * stack是一种后进先出(LIFO)策略的集合类型
 */
public class MyStack<T> {
    private Node first;
    private int length = 0;

    private class Node {
        T val;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
        // 或者 return length == 0;
    }

    public int size() {
        return length;
    }

    /**
     * 入栈, 相当于再链表头部添加一个结点
     * 改变length
     */
    public void push(T val) {
        Node oldFirst = first;
        first = new Node(); // first已存在不需要重复创建
        first.val = val;
        first.next = oldFirst;
        length++;
    }

    /**
     * 初战, 相当于删除首节点
     * 改变length
     */
    public T pop() {
        T res = first.val;
        first = first.next;
        length--;
        return res;
    }
}
