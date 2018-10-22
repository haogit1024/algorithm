package com.czh.sort;

/**
 * @author czh
 * 排序模板类, 有一些排序通用的方法
 */
abstract class SortTemplate {
    public abstract void sort(Comparable[] a);

    /**
     * 比较大小
     * @param v
     * @param w
     * @return 当 v >= w 为 false, 当 v < w 为 true
     */
    protected boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 数组交换位置
     * @param a
     * @param i
     * @param j
     */
    protected void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
            if (0 != i && i % 9 == 0) {
                System.out.println();
            }
        }
    }

    public boolean isSort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1]))
                return false;
        }
        return true;
    }
}
