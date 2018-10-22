package com.czh.sort;

import edu.princeton.cs.algs4.StdRandom;


public class SortCompare {
    /**
     * 获取运行时间毫秒数
     */
    public static long time(String alg, Double[] array) {
        long startTime = System.currentTimeMillis();
        switch (alg) {
            case "select":
                SelectSort selectSort = new SelectSort();
                selectSort.sort(array);
                break;
            case "insert":
                InsertSort insertSort = new InsertSort();
                insertSort.sort(array);
                break;
            case "shell":
                ShellSort shellSort = new ShellSort();
                shellSort.sort(array);
                break;
            case "merge":
                MergeSort mergeSort = new MergeSort();
                mergeSort.sort(array);
                break;
            case "quick":
                QuickSort quickSort = new QuickSort();
                quickSort.sort(array);
                break;
            case "quick3way":
                Quick3way quick3way = new Quick3way();
                quick3way.sort(array);
                break;
            default:
                System.out.println("not such alg:" + alg);
        }
        long endTime = System.currentTimeMillis();
        // 计算完排序时间后, 检查数组是否有序
        if (!isSort(array)) {
            System.out.println(alg + ":不是有序的");
        }
        return endTime - startTime;
    }

    public static long timeRandomInput(String alg, int length, int sortNum) {
        long total = 0;
        Double[] array = new Double[length];
        for (int n = 0; n < sortNum; n++) {
            for (int i = 0; i < length; i++) {
                array[i] = StdRandom.uniform();
            }
            total += time(alg, array);
        }
        return total;
    }

    public static boolean isSort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i-1], a[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 比较大小
     * @param v
     * @param w
     * @return 当 v > w 为 false, 当 v <= w 为 true
     */
    protected static boolean less(Comparable v, Comparable w) {
        //     compareTo：如果该对象小于、等于或大于指定对象，则分别返回负整数、零或正整数
        return v.compareTo(w) >= 0;
    }

    public static void main(String[] args) {
        long selectRunTime = timeRandomInput("select", 6000, 20);
        long insertRunTime = timeRandomInput("insert", 6000, 20);
        long shellRunTime = timeRandomInput("shell", 6000, 20);
        long mergeRunTime = timeRandomInput("merge", 6000, 20);
        long quickRunTime = timeRandomInput("quick", 6000, 20);
        long quick2wayRunTime = timeRandomInput("quick3way", 6000, 20);
        System.out.println(selectRunTime);
        System.out.println(insertRunTime);
        System.out.println(shellRunTime);
        System.out.println(mergeRunTime);
        System.out.println(quickRunTime);
        System.out.println(quick2wayRunTime);
    }
}
