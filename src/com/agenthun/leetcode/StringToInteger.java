package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/8/17.
 */
public class StringToInteger {
    public int myAtoi(String str) {
        double result = 0;
        if (str == null || str.length() < 1) return 0;
        str = str.trim();

        char flag = '+';
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }

        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }
        if (flag == '-') result = -result;
        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) result;
    }

    public static void main(String[] args) {
        String s = "        ---22a";
        System.out.println(s + " = " + new StringToInteger().myAtoi(s));
    }
}
