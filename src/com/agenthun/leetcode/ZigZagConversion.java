package com.agenthun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Agent Henry on 2015/8/13.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        int len = s.length();
        int[][] array = new int[numRows][];
        int len2 = len / 2;
        int len3 = (len - len2) / 2;
        int len1 = len - len2 - len3;
        char[] array1 = new char[len1];
        char[] array2 = new char[len2];
        char[] array3 = new char[len3];
        int l1 = 0, l2 = 0, l3 = 0;

        for (int i = 0; i < len; i++) {
            if (i % 4 == 0) array1[l1++] = s.charAt(i);
            if (i % 2 == 1) array2[l2++] = s.charAt(i);
            if (i % 4 == 2) array3[l3++] = s.charAt(i);
        }
        return String.valueOf(array1) + String.valueOf(array2) + String.valueOf(array3);
    }

    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        System.out.println(str);
        System.out.println(new ZigZagConversion().convert(str, 3));
    }
}
