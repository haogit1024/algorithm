package com.czh.nodelist;

/**
 * 链表实现队列
 * 队列是一种先进先出(FIFO)策略的集合类型
 */
public class MyQueue<T> {
    private Node first;
    private Node last;
    private int length = 0;

    private class Node {
        T val;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return length;
    }

    /**
     * 入列, 相当于在链表尾部添加一个结点
     * 当链表为空时, first和last都要指向新结点
     */
    public void enQueue(T val) {
        Node oldLast = last;
        // last指向新结点时链表添加结点还没有成功, 只用当oldLast.next = last时, 才算添加成功
        last = new Node();
        last.val = val;
        if (isEmpty()) {
            first = last;
        } else {
            // 添加尾结点
            oldLast.next = last;
        }
        length++;
    }

    /**
     * 出列, 相当于在链表头部删除一个结点
     * 删除后如果链表为空, 需要更新last的值为空
     */
    public T deQueue() {
        T res = first.val;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        length--;
        return res;
    }
}
