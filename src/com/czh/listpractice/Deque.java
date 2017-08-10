package com.czh.listpractice;

/**
 * 练习1.3.33我把left,right改成了first,last
 */
public class Deque<Item> {

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
     * 此时原来的first
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

//    public Item popLast() {
//
//    }


}
