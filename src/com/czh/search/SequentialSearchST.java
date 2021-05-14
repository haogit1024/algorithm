package com.czh.search;


import java.util.ArrayList;
import java.util.List;

/**
 * @author chenzh
 */
public class SequentialSearchST<Key, Value> {
    private class Node {
        Key key;
        Value value;
        Node next;
        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node first = null;
    private int size = 0;

    public Value get(Key key) {
        for (Node temp = first; temp != null; temp = temp.next) {
            if (key.equals(temp.key)) {
                return temp.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        for (Node temp = first; temp != null; temp = temp.next) {
            if (key.equals(temp.key)) {
                temp.value = value;
            }
        }
        first = new Node(key, value, first);
        size++;
    }

    public int size() {
        return this.size;
    }

    public void delete(Key key) {
        if (first.key.equals(key)) {
            first = first.next;
            size--;
        } else {
            for (Node lastNode = first, temp = first.next; temp != null; lastNode = temp, temp = temp.next) {
                if (temp.key.equals(key)) {
                    lastNode.next = temp.next;
                    size--;
                }
            }
        }
    }

    public boolean contains(Key key) {
        for (Node temp = first; temp != null; temp = temp.next) {
            if (temp.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Iterable<Key> keys() {
        List<Key> keys = new ArrayList<>(this.size);
        for (Node temp = first; temp != null; temp = temp.next) {
            keys.add(temp.key);
        }
        return keys;
    }

    public static void main(String[] args) {
        SequentialSearchST<Integer, String> st = new SequentialSearchST<>();
        st.put(1, "fuck");
        st.put(2, "you");
        System.out.println(st.get(1));
        System.out.println(st.get(2));
        System.out.println(st.size());
        System.out.println(st.contains(1));
        System.out.println(st.contains(2));
        st.delete(1);
        for (Integer key : st.keys()) {
            System.out.println(key);
        }
    }
}
