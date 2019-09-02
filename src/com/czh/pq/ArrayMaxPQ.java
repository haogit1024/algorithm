package com.czh.pq;

public class ArrayMaxPQ implements PQTemplate<Integer> {
    private int[] array;
    private int index = 0;

    public ArrayMaxPQ(){
        array = new int[10];
    }

    public ArrayMaxPQ(int max) {
        array = new int[max];
    }

    public ArrayMaxPQ(Integer[] array) {
        int maxLength = array.length;
        this.array = new int[maxLength];
        for (int i = 0; i < maxLength; i++) {
            this.array[i] = array[i];
        }
    }

    private void resize(int length) {
        int[] temp = new int[length];
        for (int i = 0; i < index; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    @Override
    public void insert(Integer k) {
        if (index == array.length)
            resize(array.length * 2);
        array[index++] = k;
    }

    @Override
    public Integer max() {
        return array[maxIndex()];
    }

    private int maxIndex() {
        int maxIndex = 0;
        int max = array[0];
        for (int i = 0; i < index; i++) {
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    @Override
    public Integer delMax() {
        int max = max();
        exch(maxIndex(), --index);
        // 防止对象游离, 把删除后的元素移除
        array[index] = 0;
        return max;
    }

    private void exch(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public int size() {
        return index;
    }

    public void display() {
        System.out.println("========display play========");
        for (int i = 0; i < index; i++) {
            System.out.println(i);
        }
        System.out.println("========display  end========");
    }
}
