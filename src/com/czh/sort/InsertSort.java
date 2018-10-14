package com.czh.sort;

/**
 * 插入排序
 * TODO 补全复杂度
 */
public class InsertSort extends SortTemplate {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j-1])) {
                    exch(a, j, j-1);
                } else {
                    // 因为左侧的元素已经是有序的了, 不需要重复检查
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{10,9,8,7,6,5,4,3,2,1};
        InsertSort sort = new InsertSort();
        sort.sort(a);
        sort.show(a);
        System.out.println(sort.isSort(a));
    }
}
