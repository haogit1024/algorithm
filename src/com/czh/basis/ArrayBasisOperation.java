package com.czh.basis;

import java.util.Arrays;

public class ArrayBasisOperation {
    public static double getMax(double[] array) {
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }

    public static double getAverage(double[] array) {
        double sum = 0;
        int length = array.length;
        for (int i = 0; i < length; i++)
            sum += array[i];
        return sum / length;
    }

    public static double[] copyArray(double[] array) {
        int length = array.length;
        double[] ret = new double[length];
        for (int i = 0; i < length; i++)
            ret[i] = array[i];
        return ret;
    }

    // 学习算法需要知道算法每一步的操作，对每一步都十分清楚
    // 1.0和length-1换，1和length-1-1换，2和length-1-2换，以此类推: i 和 length-1-i换
    // 2.如果数组是奇数个, 那么i只需要增加到mid(数组正中间的元素，索引为(length-1)/2 )的前一位即可，即：i < (length-1)/2
    // 3.如果数组是偶数个, 那个i只需要遍历数组的前半部分就可以了，即：i < length / 2(第五点说明)
    // 4.当数组是奇数个时, (length-1) / 2 = length/2 - 1/2; 因为length是基数, length/2=n.5(n为一个正整数),
    // 所以length/2运算结果为: length/2 - 1/2(java整数除整数结果为整数), 因此两者是相等
    // 5.当数组是偶数个时, length/2为数组一半的个数, 即：length/2是左边边数组的长度, 比左边数组最大索引的大1,是右边数组的第一位元素的索引
    // 最后得出结论：当数组个数为奇数个时, length/2是数组正中间的元素的索引; 当数组的个数为偶数个时, length/2时右边数组的第一个元素的索引
    // 所以当i < length/2时, i可以遍历一个数组的前半段(当数组是奇数个是, 不包含正中间的元素)
    public static void perversionArray(double[] array) {
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            double temp = array[i];
            array[i] = array[length -1 -i];
            array[length -1 -i] = temp;
        }
    }

    public static void main(String[] args) {
        double[] d = {1.1,1.2,1.3,1.4,1.5,1.6};
        Arrays.sort(d);
        perversionArray(d);
        Arrays.stream(d).forEach(System.out::println);
    }
}
