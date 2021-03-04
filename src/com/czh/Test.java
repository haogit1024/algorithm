package com.czh;


import com.czh.pq.ArrayMaxPQ;
import com.czh.sort.SelectSort;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private static int minIndex = -1;

    public static void main(String[] args) {
//        ArrayMaxPQ a = new ArrayMaxPQ();
//        for (int i = 0; i < 10; i++) {
//            if (i == 2)
//                System.out.println("if i:" + i);
//            System.out.println("i:" + i);
//        }
//        reverseInteger(123);
//        Integer[] a = new Integer[]{9,8,7,6,5,4,3,2,1};
//        SelectSort sort = new SelectSort();
//        sort.show(a);
//        System.out.println(myAtoi("0000-42"));
        System.out.println(myAtoi("  0000000000012345678"));
        // 2147483647
        // -2147483648
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

    /**
     * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
     *
     * 函数 myAtoi(string s) 的算法如下：
     *
     * 读入字符串并丢弃无用的前导空格
     * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
     * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
     * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
     * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
     * 返回整数作为最终结果。
     * 注意：
     *
     * 本题中的空白字符只包括空格字符 ' ' 。
     * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
     *
     * @param s
     * @return
     */
    public static int myAtoi(String s) {
        char[] num = new char[s.length() + 1];
        int numIndex = 1;
        num[0] = 'a';
        for (char item : s.toCharArray()) {
            if (!Character.isSpaceChar(item)) {
                System.out.println((int)item);
                // 排除空格
                if (num[0] == 'a' && numIndex == 1 && (item == '-' || item == '+')) {
                    num[0] = item;
                } else if ((int) item >= 48 && (int) item <= 57) {
                    num[numIndex] = item;
                    numIndex++;
                } else {
                    break;
                }
            }
        }
        if (numIndex == 1) {
            return 0;
        }
        if (num[0] == 'a') {
            num[0] = '+';
        }
        // 截断数组
        char[] finalNum = new char[numIndex];
        if (numIndex >= 0) System.arraycopy(num, 0, finalNum, 0, numIndex);
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        String numStr = new String(finalNum);
        if (isGeMax(numStr)) {
            return max;
        }
        if (isLeMin(numStr)) {
            return min;
        }
        return Integer.parseInt(numStr);
    }

    /**
     * 比较s1和s2的大小，相同返回0 s1 > s2 返回1 s1 < s2 返回-1
     * @param s1
     * @param s2
     * @return
     */
    public static int compare(String s1, String s2) {
        int s1Index = 0;
        int s2Index = 0;
        return 1;
    }

    private static boolean isGeMax(String str) {
        char label = str.charAt(0);
        int index = 0;
        if (label == '-') {
            return false;
        } else if (label == '+') {
            index = 1;
        }
        String max = String.valueOf(Integer.MAX_VALUE);
        int strLength = str.length() - index;
        int maxLength = max.length();
        if (strLength > maxLength) {
            return true;
        } else if (strLength < maxLength) {
            return false;
        } else {
            // 长度相同
            for (int i = 0; i < strLength; i++) {
                if (str.charAt(i + index) > max.charAt(i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isLeMin(String str) {
        char label = str.charAt(0);
        int index = 0;
        if (label != '-') {
            return false;
        } else {
            index = 1;
        }
        String min = String.valueOf(Integer.MIN_VALUE);
        int strLength = str.length() - index;
        int minLength = min.length() - 1;
        if (strLength > minLength) {
            return true;
        } else if (str.length() < minLength) {
            return false;
        } else {
            // 长度相等
            for (int i = 0; i < strLength; i++) {
                if (str.charAt(i + index) > min.charAt(i + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
