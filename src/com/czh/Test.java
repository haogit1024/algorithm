package com.czh;


import com.czh.pq.ArrayMaxPQ;
import com.czh.sort.SelectSort;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private static int minIndex = -1;

    public static void main(String[] args) {
        ArrayMaxPQ a = new ArrayMaxPQ();
        for (int i = 0; i < 10; i++) {
            if (i == 2)
                System.out.println("if i:" + i);
            System.out.println("i:" + i);
        }
//        reverseInteger(123);
//        Integer[] a = new Integer[]{9,8,7,6,5,4,3,2,1};
//        SelectSort sort = new SelectSort();
//        sort.show(a);
    }

    public static void testComparable() {
        Integer i1 = 1;
        Integer i2 = 2;
        System.out.println(i1.compareTo(i2));
        System.out.println(i2.compareTo(i2));
        System.out.println(i2.compareTo(i1));
    }

    public static int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        int aLength = A.length;
        int bLength = B.length;
        int subLength = aLength + bLength;
        int[] mergeArray = new int[subLength];
        int aIndex = 0;
        int bIndex = 0;
        int mIndex = 0;
        while (aIndex < aLength && bIndex < bLength) {
            if (A[aIndex] < B[bIndex]) {
                mergeArray[mIndex++] = A[aIndex++];
            } else {
                mergeArray[mIndex++] = B[bIndex++];
            }
        }
        if (aIndex < aLength) {
            while (aIndex < aLength) {
                mergeArray[mIndex++] = A[aIndex++];
            }
        } else {
            while (bIndex < bLength) {
                mergeArray[mIndex++] = B[bIndex++];
            }
        }
        return mergeArray;
    }

    // 相当于数组向后移动offset位
    public static void rotateString(char[] str, int offset) {
        // write your code here
        int strLength = str.length;
        if (strLength == 0) return;
        if (offset == 0) return;
        int index = 0;
        char temp;
        // offset strLength, 避免多余的循环。例如：length + 3 和 3的结果字符串是一样的, 所以index < offset % strLength
        while (index < offset % strLength) {
            temp = str[strLength - 1];
            for (int i = strLength -1; i >=1; i--) {
                str[i] = str[i - 1];
            }
            str[0] = temp;
            index++;
        }
    }

    public static double maxAverage(int[] nums, int k) {
        // write your code here
        int maxIndex = 0;
        int index = 0;
        int length = nums.length;
        double sum = 0;
        int begin = 1;
        while (index < k) {
            for (int i =begin; i < length; i++) {
                if (nums[i] > nums[maxIndex]) {
                    maxIndex = i;
                }
            }
            System.out.println(nums[maxIndex]);
            sum += nums[maxIndex];
            // 交换 begin-1和maxIndex
            int temp = nums[maxIndex];
            nums[maxIndex] =  nums[begin -1];
            nums[begin-1] = temp;
            begin++;
            index++;
        }
        return sum / k;
    }

    public static List<String> fizzBuzz(int n) {
        // write your code here
        List<String> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                list.add("fizz buzz");
            } else if (i % 5 == 0) {
                list.add("buzz");
            } else if (i % 3 == 0) {
                list.add("fizz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    public static int binarySearch(int[] nums, int target) {
        // write your code here
         binarySearch(nums, target, 0, nums.length);
         return minIndex;
    }

    private static void binarySearch(int[] array, int key, int left, int right) {
        int mid = left + (right - left) / 2;
        // left和right可以相等, 当left==right时: mid = left = right
        // left和right相等时如果还是没有找到, 下一步就会出现left > right的情况
        if (left > right) return;
        if (key > array[mid]) {
             binarySearch(array, key, mid + 1, right);
        } else if (key < array[mid]) {
             binarySearch(array, key,  left, mid - 1);
        } else {
            System.out.println("mid:" + mid);
            if (minIndex == -1) {
                minIndex = mid;
            } else if (mid < minIndex) {
                minIndex = mid;
            }
            binarySearch(array, key,  left, mid - 1);
        }
    }

    public static int reverseInteger(int number) {
        // write your code here
        // 只需要交换百位和个位
        int bai = number / 100;
        int shi = number % 100 / 10;
        int ge = number % 100 % 10;
        System.out.println(bai);
        System.out.println(shi);
        System.out.println(ge);
        System.out.println(number - bai * 100 + ge * 100 - ge + bai);
        return 0;
    }
}
