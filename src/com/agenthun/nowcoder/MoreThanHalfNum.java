package com.agenthun.nowcoder;

/**
 * Created by agenthun on 16/2/3.
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 */
public class MoreThanHalfNum {
    public static int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) return 0;

        int result = 0;
        int number = 0;
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (number == 0) {
                number = array[i];
                count++;
            } else {
                if (array[i] != number) {
                    if (count == 0) {
                        number = array[i];
                        count = 1;
                    } else {
                        count--;
                    }
                } else {
                    count++;
                }
            }
            if (count == 1)
                result = number;
        }
        if (checkMoreThanHalf(array, result))
            return result;
        else
            return 0;
    }

    private static boolean checkMoreThanHalf(int[] array, int number) {
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                times++;
            }
        }
        if ((times << 1) <= array.length)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        System.out.println("MoreThanHalfNum_Solution(a) = " + MoreThanHalfNum_Solution(a));
    }
}
