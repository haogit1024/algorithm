package com.czh.list;

import java.util.Iterator;

/**
 * Created by czh on 17-8-6.
 */
public class FirstList<Item> implements Iterable<Item> {

    private Node first;
    private Node last;

    private class Node {
        Item item;
        Node next;
    }

    public void insertFirst(Item value){
        Node oldFist = first;
        first = new Node();
        first.item = value;
        first.next = oldFist;
    }

    public void deleteFirst() {
        first = first.next;
    }

    public void addLast(Item value){
        Node oldLast = last;
        last = new Node();
        oldLast.next = last;
    }

    public void deleteLast() {
        Node flag = first;
        while (flag.next != null) {
            flag = flag.next;
        }
        flag.next = null;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }


}
