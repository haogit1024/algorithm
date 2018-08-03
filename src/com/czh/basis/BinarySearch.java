package com.czh.basis;

/**
 * 二分查找的时间复杂度时log2n
 * 最坏情况下：
 * 当数组是偶数个时, 每次数组都会少一半
 * 当数组时奇数个时, 第一次数组会少一半加1, 剩下的一半是偶数个的数组
 * 所以他们的复杂度是相同的
 */
public class BinarySearch {
    public static int rank(int key, int[] array) {
        return rank(key, array, 0, array.length - 1);
    }

    private static int rank(int key, int[] array, int left, int right) {
        int mid = left + (right - left) / 2;
        // left和right可以相等, 当left==right时: mid = left = right
        // left和right相等时如果还是没有找到, 下一步就会出现left > right的情况
        if (left > right) return -1;
        if (key > array[mid]) {
            return rank(key, array, mid + 1, right);
        } else if (key < array[mid]) {
            return rank(key, array, left, mid - 1);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        System.out.println(rank(2, array));
    }
}
