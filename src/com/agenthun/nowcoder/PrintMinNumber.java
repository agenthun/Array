package com.agenthun.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by agenthun on 16/1/15.
 */
public class PrintMinNumber {
    public static String printMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) return "";

        int[] clone = numbers.clone();
        printMin(clone, 0, clone.length - 1);

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < clone.length; i++) {
            buffer.append(clone[i]);
        }
        return buffer.toString();
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
