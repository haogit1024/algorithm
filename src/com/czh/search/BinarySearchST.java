package com.czh.search;

import com.czh.search.api.SortST;
import edu.princeton.cs.algs4.Queue;


/**
 * @author chenzh
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> implements SortST<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int size;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
        size = 0;
    }

    public void resize(int capacity) {
        Key[] newKeys = (Key[]) new Comparable[capacity];
        Value[] newValues = (Value[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newKeys[i] = keys[i];
            newValues[i] = values[i];
        }
        keys = newKeys;
        values = newValues;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Key mini() {
        return keys[0];
    }

    @Override
    public Key max() {
        return keys[size - 1];
    }

    @Override
    public Key floor(Key key) {
        int i = rank(key);
        if (i == 0) {
            return null;
        } else if (i < size && keys[i].compareTo(key) == 0) {
            return key;
        } else {
            return keys[i - 1];
        }
    }

    @Override
    public Key ceiling(Key key) {
        return keys[rank(key)];
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int rank(Key key) {
        int lo = 0, hi = size - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    @Override
    public Key select(int k) {
        return keys[k];
    }

    @Override
    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            return values[i];
        } else {
            return null;
        }
    }

    @Override
    public void delete(Key key) {
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            for (int j = i; j < size - 1; j++) {
                keys[j] = keys[j+1];
                values[j] = values[j+1];
            }
            size--;
        }
    }

    @Override
    public boolean contains(Key key) {
        for (Key k : keys) {
            if (k.compareTo(key) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void put(Key key, Value value) {
        if (size == keys.length) {
            resize(size * 2);
        }
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            values[i] = value;
        } else {
            for (int j = size; j > i; j--) {
                keys[j] = keys[j--];
                values[j] = values[j--];
            }
            keys[i] = key;
            values[i] = value;
            size++;
        }
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<>();
        for (int i = rank(lo); i < rank(hi); i++) {
            queue.enqueue(keys[i]);
        }
        if (contains(hi)) {
            queue.enqueue(hi);
        }
        return queue;
    }

    public void show() {
        for (int i = 0; i < size; i++) {
            System.out.print("key: " + keys[i] + ", value: " + values[i] + "\t");
            if ( (i + 1) % 5 == 0) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchST<Integer, String> st = new BinarySearchST<>(10);
        st.put(1, "a");
        st.put(2, "b");
        st.put(3, "c");
        st.put(4, "d");
        st.put(5, "e");
        st.put(6, "g");
        st.put(7, "g");
        st.put(8, "h");
        st.put(9, "i");
        st.put(10, "j");
        st.put(11, "k");
//        st.show();
//        System.out.println(st.floor(8));
//        System.out.println(st.ceiling(8));
        st.delete(7);
        st.delete(5);
//        System.out.println(st.size);
        st.show();
    }
}
