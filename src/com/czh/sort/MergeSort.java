package com.czh.sort;

/**
 * 自定线下的归并排序
 * 需要 1/2NlgN至NlgN次比较
 * 和 6NlgN次数组访问
 */
public class MergeSort extends SortTemplate {
    // 如果每次归并都创建一个新数组来存储排序结果会带来性能问题。因此我创建一个全局辅助数组
    private Comparable[] aux;
    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    /**
     * 自底向上的归并排序
     * 需要1/2NlgN至NlgN次比较, 最多访问数组6NlgN次
     */
    public void sortUE(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        // sz 是子数组的大小为 1,2,4,8... 后一个是前一个的两倍
        for (int sz = 1; sz < N; sz = sz + sz) {
            // lo 是需要归并的子数组的索引。一次会归并两个sz大小的数组, lo为这两个数组的开始索引, 每次增长2sz
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, lo, (lo + sz - 1), Math.min(lo + sz + sz - 1, N-1));
            }
        }
    }

    // 递归执行
    private void sort(Comparable[] a, int lo, int hi) {
        // 不能相等。相等时无法继续拆分子数组
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
//        System.out.println("mid=" + mid);
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        // 将需要排序的数组复制到辅助数组中
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        // 归并
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[i], aux[j])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,3,5,7,2,4,6,8,9,10,0};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sortUE(array);
        mergeSort.show(array);
    }
}
