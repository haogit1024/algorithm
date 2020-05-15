package com.czh.find;

import com.czh.find.api.SK;

import java.util.Iterator;

public class SKImpl<Key extends Comparable<Key>, Value> implements SK<Key, Value>, Iterable<Key> {


    @Override
    public void put(Key key, Value value) {

    }

    @Override
    public Value get(Key key) {
        return null;
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterable<Key> keys() {
        return this;
    }

    @Override
    public Iterator<Key> iterator() {
        return null;
    }

    private class ListIterator implements Iterator<Key> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Key next() {
            return null;
        }
    }


}
