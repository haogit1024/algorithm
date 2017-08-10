package com.czh.listpractice;

import java.util.Iterator;

/**
 * 练习1.3.32
 */
public class Steque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
        public Node(){}
        public Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        if (isEmpty()) {
            Node node = new Node(item, null);
            first = node;
            last = node;
        } else {
//            Node node = new Node(item, first);
//            first = node;
            Node oldFirst = first;
            first = new Node(item, oldFirst);
        }
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public void enQueue(Item item) {
        Node oldLast = last;
        last = new Node(item, null);
        oldLast.next = last;
        N++;
//        Node node = new Node(item, null);
//        last.next = node;
//        last = node;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ResultIterator();
    }

    /**
     * i表示已经迭代的Node个数
     */
    private class ResultIterator implements Iterator<Item> {
        private int i = 0;
        private Node iNode = first;
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
        Steque<String> steque = new Steque<>();
        steque.push("1");
        steque.push("2");
        steque.push("3");
        steque.push("4");
        steque.push("5");
        steque.enQueue("6");
        System.out.println(steque.pop());
        System.out.println("----------");
        for (String s : steque) {
            System.out.println(s);
        }
    }

}
