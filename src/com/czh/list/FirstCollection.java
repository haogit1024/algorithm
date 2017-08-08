package com.czh.list;

import java.util.Iterator;

/**
 * Created by czh on 17-8-6.
 */
public class FirstCollection<T> implements Iterable<T> {

    private T[] ts = (T[]) new Object[1];
    private int N = 0;

    private boolean isEmpty(){
        return N == 0;
    }

    private void resize(int max) {
        T[] temp = (T[]) new Object[max];
        for (int i = 0; i < ts.length; i++) {
            temp[i] = ts[i];
        }
        ts = temp;
    }

    public void push(T value) {
        if (N == ts.length) {
            resize(N * 2);
        }
        ts[N++] = value;
    }

    public T pop(){
        T result = ts[--N];
        if (N > 0 && N == ts.length / 4) {
            resize(ts.length / 2);
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new ResultIterator();
    }

    private class ResultIterator implements Iterator<T> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return ts[--i];
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        FirstCollection<String> coll = new FirstCollection<>();
        coll.push("fuck");
        coll.push("you");
        for (String s : coll) {
            System.out.println(s);
        }
        System.out.println("---------");
        System.out.println(coll.pop());
    }
}
