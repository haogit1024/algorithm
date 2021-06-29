package com.czh.search.exercises;

import com.czh.search.api.SortST;

import java.util.ArrayList;
import java.util.List;

/**
 * 习题3.1.3 使用有序链表实现有序符号表API
 * @param <Key>
 * @param <Value>
 */
public class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> implements SortST<Key, Value> {
    private class Node {
        Key key;
        Value value;
        Node prev;
        Node next;
        public Node(Key key, Value value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public void put(Key key, Value value) {
        if (first == null) {
            // 空链表初始化
            first = new Node(key, value, null, null);
            last = first;
        } else if (last.key.compareTo(key) < 0) {
            Node oldLast = last;
            last = new Node(key, value, oldLast, null);
            oldLast.next = last;
        } else {
            for (Node temp = first; temp != null; temp = temp.next) {
                if (temp.key.compareTo(key) > 0) {
                    // 已经获取到比key大的节点
                    Node prev = temp.prev;
                    if (prev == null) {
                        first = new Node(key, value, null, temp);
                        temp.prev = first;
                    } else {
                        Node newNode = new Node(key, value, prev, temp);
                        prev.next = newNode;
                        temp.prev = newNode;
                    }
                    break;
                }
            }
        }
        size++;
    }

    @Override
    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.compareTo(key) == 0) {
                return x.value;
            }
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        if (key.compareTo(first.key) == 0) {
            deleteMin();
            return;
        }
        if (key.compareTo(last.key) == 0) {
            deleteMax();
            return;
        }
        for (Node x = first; x != null; x = x.next) {
            if (x.key.compareTo(key) == 0) {
                x.prev.next = x.next;
                x.next.prev = x.prev;
                size--;
            }
        }
    }

    @Override
    public boolean contains(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.compareTo(key) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Key mini() {
        return first.key;
    }

    @Override
    public Key max() {
        return last.key;
    }

    @Override
    public Key floor(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.compareTo(key) == 0) {
                return x.key;
            }
            if (x.key.compareTo(key) > 0) {
                if (x.prev != null) {
                    return x.prev.key;
                }
                break;
            }
        }
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.compareTo(key) >= 0) {
                return x.key;
            }
        }
        return null;
    }

    @Override
    public int rank(Key key) {
        int i = 0;
        for (Node x = first; x != null; x = x.next) {
            if (x.key.compareTo(key) >= 0) {
                break;
            }
            i++;
        }
        return i;
    }

    @Override
    public Key select(int k) {
        int i = 0;
        for (Node x = first; x != null; x = x.next) {
            if (i == k) {
                return x.key;
            }
            i++;
        }
        return null;
    }

    @Override
    public void deleteMin() {
        if (isEmpty()) {
            return;
        }
        first = first.next;
        first.prev = null;
        size--;
    }

    @Override
    public void deleteMax() {
        if (isEmpty()) {
            return;
        }
        last = last.prev;
        last.next.prev = null;
        size--;
    }

    @Override
    public int size(Key lo, Key hi) {
        int s = rank(hi) - rank(lo);
        if (contains(hi)) {
            s++;
        }
        return s;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        List<Key> res = new ArrayList<>();
        // 先获取到lo向上取整所在的节点
        Node temp = first;
        while (temp != null) {
            if (temp.key.compareTo(lo) >= 0) {
                break;
            }
            temp = temp.next;
        }
        for (Node x = temp; x != null; x = x.next) {
            res.add(x.key);
        }
        return res;
    }

    @Override
    public Iterable<Key> keys() {
        List<Key> res = new ArrayList<>(size);
        for (Node x = first; x != null; x = x.next) {
            res.add(x.key);
        }
        return res;
    }

    public void show() {
        for (Node x = first; x != null; x = x.next) {
            Key prev = null;
            Key next = null;
            if (x.prev != null) {
                prev = x.prev.key;
            }
            if (x.next != null) {
                next = x.next.key;
            }
            System.out.println("key: " + x.key + ", value: " + x.value + ", prev: " + prev + ", next: " + next);
        }
    }

    public static void main(String[] args) {
        OrderedSequentialSearchST<Integer, String> st = new OrderedSequentialSearchST<>();
//        st.put(2, "b");
        st.put(1, "a");
//        st.put(6, "f");
        st.put(3, "c");
//        st.put(4, "d");
        st.put(7, "f");
        st.put(5, "e");
//        st.delete(5);
//        st.delete(1);
//        st.delete(7);
        st.show();
        System.out.println(st.size(1, 2));
        System.out.println(st.size(1, 3));
//        System.out.println(st.rank(1));
//        System.out.println(st.rank(2));
//        System.out.println(st.rank(3));
    }
}
