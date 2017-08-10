package com.czh.listpractice;

import java.util.Iterator;

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

    public int size() {
        return N;
    }

    public void add(Item item) {
        if (isEmpty()) {
            DoubleNode node = new DoubleNode(item, null , null);
            first = node;
            last = node;
        } else {
            DoubleNode oldFirst = first;
            DoubleNode node = new DoubleNode(item, first, last);
            first.next = node;
            first = node;
            last.pre = node;
        }
        N++;
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
            System.out.println("item = " + item);
            return item;
        }
    }

    public static void main(String[] args) {
        DoubleCollection<String> c = new DoubleCollection<>();
        c.add("1");
        c.add("2");
        c.add("3");
        c.add("4");
        for (String s : c) {
            System.out.println(c);
        }
    }
}
