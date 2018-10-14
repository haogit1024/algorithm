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
            default:
                    System.out.println("not such alg:" + alg);
        }
//        if (alg.equals("select")) {
//            SelectSort selectSort = new SelectSort();
//            selectSort.sort(array);
//        } else if (alg.equals("insert")) {
//            InsertSort insertSort = new InsertSort();
//            insertSort.sort(array);
//        } else if (alg.equals("shell")) {
//            ShellSort shellSort = new ShellSort();
//            shellSort.sort(array);
//        } else {
//            System.out.println("not such alg");
//        }
        long endTime = System.currentTimeMillis();
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

    public static void main(String[] args) {
        long selectRunTime = timeRandomInput("select", 2000, 20);
        long insertRunTime = timeRandomInput("insert", 2000, 20);
        long shellRunTime = timeRandomInput("shell", 2000, 20);
        long mergeRunTime = timeRandomInput("merge", 2000, 20);
        System.out.println(selectRunTime);
        System.out.println(insertRunTime);
        System.out.println(shellRunTime);
        System.out.println(mergeRunTime);
    }
}
