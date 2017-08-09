package com.czh.list;

import java.util.Iterator;

/**
 * Created by czh on 17-8-6.
 */
public class FirstStack<Item> implements Iterable<Item> {

    private int N;
    private Node first;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop(){
        Item result =  first.item;
        first = first.next;
        N--;
        return result;
    }

    //练习1.3.7添加peek().返回最近添加的元素,但不弹出
    public Item[] peek(){
        int n = 0;
        Node index = first;
        Item[] items = (Item[]) new Object[5];
//        Item[] items = new Item[];
        while (n < 5) {
            items[n] = index.item;
            index = index.next;
            n++;
        }
        return items;
    }

    public Item deleteLast(){
//        Node index;
//        for (index = first; index.next.next != null; index = index.next){
//
//        }
        Node index = first;
        while (null != index.next.next) {
            index = index.next;
        }
        Item item = index.next.item;
        index.next = null;
        N--;
        return item;
    }

    /**
     * 练习1.3.24
     * @param item
     */
    public void removeAfter(Item item) {
        if (item == null) {
            return;
        }
//        if (first.item.equals(item)) {
//            first = null;
//        } else {
//            Node index = first;
//            while (!index.next.item.equals(item)) {
//                index = index.next;
//            }
//            index.next = null;
//        }

        Node index = first;
        while (!index.item.equals(item)) {
            index = index.next;
        }
        index.next = null;
    }

    public Node reverse(FirstStack stack) {
        Node reverse = null;
        Node index = stack.first;
        while (index != null) {
            Node second = index.next;
            index.next = reverse;
            reverse = index;
            index = second;
        }
        return reverse;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ResultIterator();
    }

    private class ResultIterator implements  Iterator<Item> {
        Node index = first;
        @Override
        public boolean hasNext() {
            return index != null;
        }

        @Override
        public Item next() {
            Item result = index.item;
            index = index.next;
            return result;
        }
    }

    public static void main(String[] args) {
        FirstStack<String> fs = new FirstStack<>();
        fs.push("1");
        fs.push("2");
        fs.push("3");
        fs.push("4");
        fs.push("5");
        fs.push("6");
        for (String o : fs) {
            System.out.println(o);
        }
        System.out.println("--------------");
        fs.removeAfter("3");
        System.out.println("--------------");
        for (String o : fs) {
            System.out.println(o);
        }
    }
}
