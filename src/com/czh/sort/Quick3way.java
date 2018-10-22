package com.czh.sort;

import edu.princeton.cs.algs4.StdRandom;

public class Quick3way extends SortTemplate {

    @Override
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    /**
     * 三向切分的快速排序, 需要维护下面几个指针
     * 一个指针lt使得a[lo..lt-1]中的元素都小于v
     * 一个指针gt使得a[gt+1..hi]中的元素都大于1
     * 一个指针i 是的a[lt...i-1]中的元素都等于v
     * a[i..gt]中的元素待定
     * 当gt = i - 1时循环结束
     * :如果不存在相等的元素, 那么lt = i - 1, a[lt] = v, a[lt] > a[lo..lt-1], a[lt] < a[gt+1..hi], 所以a[lt]位置正确
     * :如果存在相等的元素, 那么数组被切分为三部分元素相等位置正确
     * 处理：
     * v为切人元素
     * if a[i] < v, exch(a, lt, i) lt++, i++
     * if a[i] > v, exch(a, i, gt) gt--
     * if a[i] = v, i++
     * @param a 需要排序的数组
     * @param lo 数组最小索引
     * @param hi 数组最大索引
     */
    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            // 终止递归
            return;
        }
        // 初始化指针和切分元素
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                exch(a, lt++, i++);
            } else if (i > 0) {
                exch(a, i, gt--);
            } else {
                i++;
            }
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1,3,5,7,2,4,6,8,9,10,0};
        Quick3way quick3way = new Quick3way();
        quick3way.sort(a);
        quick3way.show(a);
    }
}
