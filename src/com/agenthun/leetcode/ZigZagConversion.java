package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/8/13.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        int len = s.length();
        if (numRows < 1) return null;
        if (numRows == 1) return s;

        int delta = 2 * numRows - 2;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < len; j++) {
                if (j % delta == i || j % delta == (delta - i)) stringBuilder.append(s.charAt(j));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        System.out.println(str);
        System.out.println(new ZigZagConversion().convert(str, 5));
    }
}
