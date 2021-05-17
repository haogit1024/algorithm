package com.czh.basis;

/**
 * @author czh
 * 各种链表结点操作方法
 * 链表的定义: 链表是一种递归的数据结构, 他或者为空(null), 或者是指向一个结点的引用,
 * 该结点含有一个泛型的元素和一个指向另一条链表的引用.
 * 所以一条链表可以只有一个结点, 也可以由多个结点组成("指向另一条链表的引用"不为空(null)), 或者为空(null)
 */
public class NodeBasisOperation<T> {
    private Node first;
    private Node last;
    private int size;
    private class Node {
        T val;
        Node next;
    }

    /**
     * 先将first保存再oldFirst中, 然后创建一个新结点, 将val设置成新的value, next指向oldFirst
     */
    public void addFirst(T val) {
        if (first == null && last == null) {
            Node temp = new Node();
            temp.val = val;
            first = temp;
            last = temp;
        }
        Node oldFirst = first;
        first = new Node();
        first.val = val;
        first.next = oldFirst;
    }

    /**
     * 先将last保存在oldLast中, 然后创建一个新结点, 将val设置成新的value, 并将last指向新结点和oldLast的next只指向last
     */
    public void addLast(T val) {
        Node oldLast = last;
        last = new Node();
        last.val = val;
        oldLast.next = last;
    }

    /**
     * 首结点只有一个引用 first
     * 只要将first指向first.next, first. 虽然原来的first.next指向下一个结点, 但是已经没有其他引用指向这个结点了
     * 所以这个结点会被jvm回收
     */
    public T removeFirst() {
        T res = first.val;
        first = first.next;
        return res;
    }

    /**
     * 尾结点只有两个引用, 1.last 2.上一个结点的next
     * 因此便利链表找到next==last的结点, 将last指向该结点, 把该结点的next指向null. 这时原来的尾结点成为孤儿对象会被jvm回收
     */
    public T removeLast() {
        T res = last.val;
        for (Node temp = first; temp != null; temp = temp.next) {
            if (temp.next == last) {
                temp.next = null;
            }
        }
        return res;
    }

    public void insertVal(T val, int index) {
        int i = 0;
        for (Node temp = first; temp != null; temp = temp.next) {
            if (i == index) {

            }
            i++;
        }
    }

    /**
     * 除了首尾结点的其他结点都只有一个引用, 就是上一个结点的next
     */
    public T remove(int index) {
        return null;
    }
    
    public void foreach() {
        for (Node i = first; i.next != null; i = i.next) {
            
        }
    }
}
