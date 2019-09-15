package com.czh.find;

import java.util.ArrayList;
import java.util.List;

/**
 * @author czh
 * 一个简单的字符表
 */
public class SequentialSearchST<Key, Value> {
    private Node first;
    private int size = 0;
    class Node {
        Key key;
        Value value;
        Node next;
        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value get(Key key) {
        for (Node temp = first; temp != null; temp = temp.next) {
            if (temp.key.equals(key)) {
                return temp.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        for (Node temp = first; temp != null; temp = temp.next) {
            if (temp.key.equals(key)) {
                temp.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        size++;
    }

    public int size() {
        return size;
    }

    public List<Key> keys() {
        List<Key> keys = new ArrayList<>(size);
        for (Node temp = first; temp != null; temp = temp.next) {
            keys.add(temp.key);
        }
        return keys;
    }

    public Value delete(Key key) {
        Value res;
        if (first.key.equals(key)) {
            // 如果是首节点
            res = first.value;
            first = first.next;
            size--;
            return res;
        } else {
            // 不是首节点
            for (Node temp = first; temp.next != null; temp = temp.next) {
                if (temp.next.key.equals(key)) {
                    res = temp.next.value;
                    temp.next = temp.next.next;
                    size--;
                    return res;
                }
            }
        }
        return null;
    }

    public void display() {
        for (Node temp = first; temp != null; temp = temp.next) {
            System.out.printf("key: %s, value: %s\n", temp.key, temp.value);
        }
    }

    public static void main(String[] args) {
        SequentialSearchST<String, String> st = new SequentialSearchST<>();
        st.put("1", "a");
        st.put("2", "b");
        st.put("3", "c");
        st.put("4", "d");
        st.put("5", "e");
        st.put("1", "f");
        System.out.println(st.delete("1"));
        st.display();
        System.out.println(st.size());
        System.out.println(st.get("2"));
    }
}
