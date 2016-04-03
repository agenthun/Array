package com.agenthun.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by agenthun on 16/1/15.
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    public static String printMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) return "";

        int[] clone = numbers.clone();
        printMin(clone, 0, clone.length - 1);
//        quickSort(clone, 0, clone.length - 1);

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < clone.length; i++) {
            buffer.append(clone[i]);
        }
        return buffer.toString();
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int temp = array[i];
            while (i < j) {
                while (i < j && array[j] >= temp) j--;
                if (i < j) array[i++] = array[j];
                while (i < j && array[i] < temp) i++;
                if (i < j) array[j--] = array[i];
            }
            array[i] = temp;
            quickSort(array, left, i - 1);
            quickSort(array, i + 1, left);
        }
    }

    private static void printMin(int[] a, int start, int end) {
        //快速排序
        if (start < end) {
            int number = a[end];
            int cur = start;
            for (int i = start; i < end; i++) {
                if (isSmall(String.valueOf(a[i]), String.valueOf(number))) {
                    int temp = a[i];
                    a[i] = a[cur];
                    a[cur] = temp;
                    cur++;
                }
            }
            a[end] = a[cur];
            a[cur] = number;
            printMin(a, 0, cur - 1);
            printMin(a, cur + 1, end);
        }
    }

    private static boolean isSmall(String s, String t) {
        String left = s + t;
        String right = t + s;
        boolean res = false;

        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) < right.charAt(i)) {
                return true;
            } else {
                if (left.charAt(i) > right.charAt(i))
                    return false;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("array = ");
        String str = reader.readLine();
        String[] aStr = str.split(" ");
        int[] a = new int[aStr.length];
        for (int i = 0; i < aStr.length; i++) {
            a[i] = Integer.parseInt(aStr[i]);
        }

        System.out.println("printMinNumber(a) = " + printMinNumber(a));
    }
}
