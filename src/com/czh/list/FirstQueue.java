package com.czh.list;

import jdk.nashorn.internal.ir.IndexNode;

import java.util.Iterator;
import java.util.Queue;

/**
 * Created by czh on 17-8-6.
 */
public class FirstQueue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;
    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void enQueue(Item value) {
        Node oldLast = last;
        last = new Node();
        last.item = value;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;;
        }
        N++;
    }

    public Item deQueue() {
        Item result = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return result;
    }

    /**
     * 练习1.3.20
     * 当k=1时,删除头结点,但k!=1时删除普通节点
     * @param k 需要删除的索引值
     * @return 返回被删除元素的item
     */
    public Item delete(int k) {
        if (k > size()) {
            return null;
        }
        if (k == 1) {
            Item item = first.item;
            first = first.next;
            N--;
            return item;
        } else {
            int index = 1;
            Node indexNode = first;
            while (k - 1 > index) {
                indexNode = indexNode.next;
                index++;
            }
            Item item = indexNode.next.item;
            indexNode.next = indexNode.next.next;
            N--;
            return item;
        }
    }

    /**
     * 练习1.3.21
     * @param queue
     * @param item
     * @return
     */
    public boolean find(FirstQueue queue, Item item) {
        for (Node index = queue.first; index != null; index = index.next) {
            if (index.item.equals(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 练习1.3.25
     * @param item
     * @param target
     */
    public void insertAfter(Item item, Item target) {
        Node index = first;
        while (!index.item.equals(item)) {
            index = index.next;
        }
        Node t = new Node();
        t.item = target;
        Node oldNext = index.next;
        index.next = t;
        t.next = oldNext;
    }

    /**
     * 练习1.3.26
     * @param queue
     * @param item
     */
    public void remove(FirstQueue<Item> queue, Item item) {
        Node index = first;
//        if (index.item.equals(item)) {
//            first = first.next;
//        } else {
//            for (Node i = first; i.next != null; i = i.next) {
//                if (i.next.item.equals(item)) {
//                    i.next = i.next.next;
//                }
//            }
//        }
        if (index.item.equals(item)) {
            first = first.next;
        }
        index = first;
        while (index.next != null) {
            if (index.next.item.equals(item)) {
                index.next = index.next.next;
            } else {
                index = index.next;
            }
        }
    }

    /**
     * 练习1.3.27
     */
    public int max(FirstQueue<Integer> queue) {
        FirstQueue<Integer>.Node index = queue.first;
        int max = index.item;
        index = index.next;
        while (index != null) {
            if (index.item > max) {
                max = index.item;
            }
            index = index.next;
        }
        return max;
    }

    /**
     * 练习1.3.28
     */
    public int recursionMax(FirstQueue<Integer> queue) {
        FirstQueue<Integer>.Node index = queue.first;
        int max = index.item;
        index = index.next;
        return recursionMax(index, max);
    }

    public int recursionMax(FirstQueue<Integer>.Node index, int max) {
        if (index == null) {
            return max;
        }
        if (index.item > max) {
            max = index.item;
        }
        index = index.next;
        return recursionMax(index, max);
    }

    @Override
    public Iterator<Item> iterator() {
        return new ResultIterator();
    }

    private class ResultIterator implements Iterator<Item> {
        private Node index = first;
        @Override
        public boolean hasNext() {
            return index != null;
        }

        @Override
        public Item next() {
            Item item = index.item;
            index = index.next;
            return item;
        }
    }

    public static void main(String[] args) {
//        FirstQueue<String> f = new FirstQueue<>();
//        f.enQueue("1");
//        f.enQueue("2");
//        f.enQueue("3");
//        f.enQueue("3");
//        f.enQueue("3");
//        f.enQueue("4");
//        f.enQueue("5");
//        f.enQueue("6");
//        f.enQueue("7");
//        for (String s : f) {
//            System.out.println(s);
//        }
//        System.out.println("--------------");
        FirstQueue<Integer> fi = new FirstQueue<>();
        fi.enQueue(1);
        fi.enQueue(2);
        fi.enQueue(3);
//        fi.enQueue(9);
        fi.enQueue(5);
        fi.enQueue(6);
        fi.enQueue(7);
        fi.enQueue(8);
        System.out.println(fi.recursionMax(fi));

    }
}
