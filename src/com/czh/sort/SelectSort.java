package com.czh.sort;

/**
 * 选择排序
 * TODO 补全复杂度
 */
public class SelectSort extends SortTemplate {
    @Override
    public void sort(Comparable[] a) {
        for (int i= 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min])) {  // 比较次数为 N + (N -1) + (N - 2) + ... + 3 + 2 + 1 = n*n/2 + n/2 近似为n*n/2
                    min = j;
                }
            }
            exch(a, i, min); // 交换次数为最外层循环执行次数 -- N
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{10,9,8,7,6,5,4,3,2,1};
        Integer[] a1 = new Integer[]{1,2,3,4,5,6,7,8,9};
        SelectSort sorter = new SelectSort();
        sorter.sort(a);
        sorter.show(a);
    }
}
