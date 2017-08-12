package com.czh.listpractice;

/**
 * 练习1.3.33动态数组实现
 */
public class ResizingArrayDeque<Item> {
    private Item[] a = (Item[]) new Object[10];
    private int N = 0;

    public void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    //如果要在开头添加一个节点,需要先把数组先向友移一位
    public void pushFirst(Item item) {
        if (N == a.length) {
            resize(a.length * 2);
        }
        //i 表示需要移动到的位置,i-1表示需要移动的元素,所以不包过0
        for (int i = N; i > 0; i--) {
            a[i] = a[i - 1];
        }
        a[0] = item;
        N++;
    }

    public void pushLast(Item item) {
        if (N == a.length) {
            resize(a.length * 2);
        }
        a[N++] = item;
    }

    /**
     * 删除第一个元素,只需要把下表1开始的元素向左移动一位和把最后一位元素清空就可以了
     */
    public Item popFirst() {
        Item item = a[0];
        for (int i = 1; i < N; i++) {
            a[i - 1] = a[i];
        }
        a[--N] = null;//避免对象游离
        if (N < a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    public Item popLast() {
        Item item = a[--N];
        a[N] = null;//避免对象游离
        if (N < a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    public void display() {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public boolean test(){
        return a[--N] == a[N];
    }

    public static void main(String[] args) {
        ResizingArrayDeque<String> deque = new ResizingArrayDeque<>();
        deque.pushFirst("1");
        deque.pushFirst("2");
        deque.pushFirst("3");
        deque.pushFirst("4");
        deque.pushFirst("5");
        deque.pushFirst("6");

        deque.pushLast("7");
        deque.pushLast("8");
        deque.pushLast("9");
        deque.pushLast("10");
        deque.display();
        System.out.println("-----------");
        System.out.println(deque.popFirst());
        System.out.println(deque.popLast());
        System.out.println("-----------");
        deque.display();
//        System.out.println(deque.test());
    }

}
