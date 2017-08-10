package com.czh.listpractice;

import java.util.Iterator;

/**
 * 练习1.3.31
 */
public class DoubleCollection<Item> implements Iterable<Item> {
    private DoubleNode first;
    private DoubleNode last;
    private int N;

    private class DoubleNode {
        Item item;
        DoubleNode pre;
        DoubleNode next;

        public DoubleNode(Item item, DoubleNode pre, DoubleNode next){
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    //注意同时更新oldFirst.pre和last.next,它们都指向first
    public int size() {
        return N;
    }

    public void add(Item item) {
//        if (isEmpty()) {
//            DoubleNode node = new DoubleNode(item, null , null);
//            first = node;
//            last = node;
//        } else {
//            DoubleNode node = new DoubleNode(item, last, first);
//            first = node;
//            last.next = first;
//        }
        DoubleNode oldFirst = first;
        first = new DoubleNode(item, last, oldFirst);
        if (isEmpty()) {
            last = first;
        } else {
            oldFirst.pre = first;
            last.next = first;
        }
        N++;
    }

    public void display(){
        System.out.println(first.item);
    }

    @Override
    public Iterator<Item> iterator() {
        return new ResutlIterator();
    }

    private class ResutlIterator implements  Iterator<Item> {
        int i = 0;
        DoubleNode iNode = first;
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
        DoubleCollection<String> c = new DoubleCollection<>();
        c.add("1");
        c.add("2");
        c.add("3");
        c.add("4");
        c.N = 2 * c.N;
        for (String s : c) {
            System.out.println(s);
        }
//        c.display();
    }
}
