package com.czh.listpractice;

import java.util.Iterator;

/**
 * 练习1.3.33我把left,right改成了first,last
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node pre;
        Node next;

    }

    private boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    //注意同时更新oldFirst.pre和last.next,它们都指向first
    public void pushFirst(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        if (isEmpty()) {
            last = first;
        } else {
            first.pre = last;
            first.next = oldFirst;
            oldFirst.pre = first;
            last.next = first;
        }
        N++;
    }

    //注意同时更新oldLast.next和first.pre,它们都指向last
    public void pushLast(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) {
            first = last;
        } else {
            last.pre = oldLast;
            last.next = first;
            first.pre = last;
            oldLast.next = last;
        }
        N++;
    }

    /**
     * 删除first步骤如下
     * 1.将first指向第二个节点 => fist = first.next
     * 2.将first(此时first是原来的第二个节点)前缀指向last => first.pre = last
     * 3.将last的后缀指向first(此时first是原来的第二个节点) => last.next = first
     * 此时没有引用指向原来的first,first将被GC回收
     */
    public Item popFirst() {
        Item item = first.item;
//        if (N == 1) {
//            first = null;
//            last = null;
//        } else {
//            last.next = first.next;
//            first.next.pre = last;
//        }
        first = first.next;
        if (N == 1) {
            last = first;
        } else {
            first.pre = last;
            last.next = first;
        }
        N--;
        return item;
    }

    /**
     * 删除last步骤如下
     * 1.将last指向倒数第二个节点 => last = last.pre
     * 2.将last(此时是原来的倒数第二个节点)的后缀指向first => last.next = first
     * 3.将first的前缀指向last(此时是原来的倒数第二个节点的后缀指向) => first.pre = last
     */
    public Item popLast() {
        Item item = last.item;
        last = last.pre;
        if (isEmpty()) {
            first = last;
        } else {
            last.next = first;
            first.pre = last;
        }
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ResultIterator();
    }

    private class ResultIterator implements Iterator<Item> {
        private Node iNode = first;
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < N;
        }

        @Override
        public Item next() {
            Item item = iNode.item;
            iNode = iNode.next;
            i++;
            return item;
        }
    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        deque.pushFirst("1");
        deque.pushFirst("2");
        deque.pushFirst("3");
        deque.pushLast("4");

//        System.out.println(deque.popFirst());
//        System.out.println(deque.popLast());
//        deque.popFirst();
//        deque.popLast();
//        deque.N = deque.N * 2;

        for (String s : deque) {
            System.out.println(s);
        }
        System.out.println("-----------");
        deque.popFirst();
        deque.popLast();
        for (String s : deque) {
            System.out.println(s);
        }
    }
}
