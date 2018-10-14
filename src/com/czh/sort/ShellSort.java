package com.czh.sort;

/**
 * 希尔排序, 插入排序的一种改进型排序
 * TODO 补全复杂度
 */
public class ShellSort extends SortTemplate {
    @Override
    public void sort(Comparable[] a) {
        int length = a.length;
        int h = 1;
        // 实现递增序列
        while (h < length / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (less(a[j], a[j-1])) {
                        exch(a, j, j-1);
                    } else {
                        // 已经有序不需要再检查
                        break;
                    }
                }
            }
            // 缩小递增序列
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{10,9,8,7,6,5,4,3,2,1};
        ShellSort shellSort = new ShellSort();
        shellSort.sort(a);
        shellSort.show(a);
    }
}
