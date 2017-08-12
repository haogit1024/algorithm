package com.czh.listpractice;

import java.util.Iterator;
/**
 * 练习1.3.34
 */
public class RandomBag<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[10];
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void add(Item item) {
        if (N == a.length) {
           resize(a.length * 2);
        }
        a[N++] = item;
    }

    private void display() {
        for (Item item : a) {
            System.out.println(item);
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ResultIterator();
    }

    private class ResultIterator implements Iterator<Item> {
        private Item[] index = (Item[]) new Object[N];
        private int i;

        //把a复制到index,通过洗牌算法打乱数组顺序
        public ResultIterator(){
            for (int i = 0; i < N; i++) {
                index[i] = a[i];
            }
            for (int i = 0; i < N; i++) {
                int right = mathRandom(i, N - 1);
                swap(index, i, right);
            }
        }

        //(数据类型)(最小值+Math.random()*(最大值-最小值+1))
        private int mathRandom(int min, int max){
            return (int)(min + Math.random() * (max - min + 1));
        }

        private void swap(Item[] a, int left, int right) {
            Item temp = a[left];
            a[left] = a[right];
            a[right] = temp;
        }

        @Override
        public boolean hasNext() {
            return i < N;
        }

        @Override
        public Item next() {
            return index[i++];
        }
    }

    public static void main(String[] args) {
        RandomBag<String> bag = new RandomBag<>();
        bag.add("1");
        bag.add("2");
        bag.add("3");
        bag.add("4");
        bag.add("5");
        bag.add("6");
        for (String s : bag) {
            System.out.println(s);
        }
        System.out.println("---------");
        bag.display();
    }
}
