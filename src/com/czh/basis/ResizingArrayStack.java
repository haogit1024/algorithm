package com.czh.basis;

import java.util.Iterator;

/**
 * 数组实现的stack
 */
public class ResizingArrayStack<T> implements Iterable<T> {
    private T[] array = (T[]) new Object[1];
    // index 从0开始, 是即将插入的元素的索引, 也是添加元素后数组的长度(数组初始化时, length为1, index为0), 数组目前最大的索引是index-1
    private int index = 0;

    public void resize(int max) {
        T[] temp = (T[]) new Object[max];
        for (int i = 0; i < index; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    public int size() {
        return index;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public void push(T val) {
        if (index == array.length)
            resize(array.length * 2);
        array[index++] = val;
    }

    // index 从0开始, 是即将插入的元素的索引, 也是数组的长度, 数组目前最大的索引是index-1
    public T pop() {
        T ret = array[--index];
        array[index] = null;
        // index不可能小于0, index等于0时(stack为空), array为空(数组初始化时, length为1, index为0), 这时length/4=0, length/2=0
        // 这时候如果执行resize, 数组将不能再不改变大小的情况下执行push
        if (array.length / 4 == index && index > 0)
            resize(array.length / 2);
        return ret;
    }

    /**
     * 该函数每次foreach都会执行
     */
    @Override
    public Iterator<T> iterator() {
        return new ResizingArrayIterator();
    }

    private class ResizingArrayIterator implements Iterator<T> {
        // 每次循环都回返回一个ResizingArrayIterator, 所以每次循环都会执行, 所以每次循环都会初始化为index
        int n = index;
        @Override
        public boolean hasNext() {
            return n > 0;
        }

        @Override
        public T next() {
            return array[--n];
        }
    }

    public static void main(String[] args) {
        ResizingArrayStack<Integer> stack = new ResizingArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        for (Integer i : stack) {
            System.out.println(i);
        }
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        System.out.println("--------------");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
    }
}
