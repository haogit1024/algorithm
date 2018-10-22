package com.czh.sort;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 快速排序平均需要~2NlnN次比较, 最多需要N*N/2次比较, 但是随机打乱数组能够防止这种情况
 */
public class QuickSort extends SortTemplate {
    @Override
    public void sort(Comparable[] a) {
        // 随机打乱元素, 消除对输入的依赖
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            // 终止递归
            return;
        }
        int j = partition(a, lo, hi);
        // j >= lo, 但是 j - 1可能会 < lo
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private int partition(Comparable[] a, int lo, int hi) {
        // 左右扫描指针
        int i = lo, j = hi + 1;
        // 切分元素
        Comparable v = a[lo];
        while (true) {
            // 左扫描, 寻找一个比切分元素大的元素
            while (less(a[++i], v)) { // 当判断不成立时, 出现比切分元素大的元素
                // 终止循环
                if (i == hi) {
                    break;
                }
            }
            // 右扫描, 寻找一个比切分元素小的元素
            while (less(v, a[--j])) { // 当判断不成立时, 出现比切分元素小的元素
                // 终止循环
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                // 左右指针相遇时, 跳出循环, 交换切分元素
                break;
            }
            // 交换左右扫描得到的元素
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1,3,5,7,2,4,6,8,9,10,0};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(a);
        quickSort.show(a);
    }
}
