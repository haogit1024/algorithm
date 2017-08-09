package com.czh.listpractice;

/**
 * 练习1.3.30
 */
public class RingQueue<Item> {
    private Node last;
    private int N;

    public boolean isEmpty(){
        return last == null;
    }

    public int size() {
        return N;
    }

    private class Node {
        Item item;
        Node next;
    }

    public void enQueue(Item item) {
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            last = node;
            last.next = node;
        } else {
            Node oldLast = last;
            Node first = last.next;
            last = node;
            oldLast.next = last;
            last.next = first;
        }
        N++;
    }

    public Item deQueue(){
        if (N == 1) {
            Item item = last.item;
            last = null;
            N--;
            return item;
        } else {
            Item item = last.next.item;
            last.next = last.next.next;
            N--;
            return item;
        }
    }

    public void display(){
        Node first = last.next;
        while (first != null) {
            System.out.println(first.item);
            if (first == last) {
                return;
            }
            first = first.next;
        }
    }

    public static void main(String[] args) {
        RingQueue<String> queue = new RingQueue<>();
        queue.enQueue("1");
        queue.enQueue("2");
        queue.enQueue("3");
        queue.enQueue("4");
//        System.out.println(queue.deQueue());
//        System.out.println(queue.deQueue());
//        System.out.println(queue.deQueue());
//        System.out.println(queue.deQueue());
//        System.out.println(queue.isEmpty());
        queue.display();
        queue.display();
    }
}
