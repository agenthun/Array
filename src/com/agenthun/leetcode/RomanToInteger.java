package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/8/21.
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        int result = toNum(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (toNum(s.charAt(i - 1)) < toNum(s.charAt(i))) {
                result += toNum(s.charAt(i)) - 2 * toNum(s.charAt(i - 1));
            } else {
                result += toNum(s.charAt(i));
            }
        }
        return result;
    }

    int toNum(char c) {
        int res;
        switch (c) {
            case 'I':
                res = 1;
                break;
            case 'V':
                res = 5;
                break;
            case 'X':
                res = 10;
                break;
            case 'L':
                res = 50;
                break;
            case 'C':
                res = 100;
                break;
            case 'D':
                res = 500;
                break;
            case 'M':
                res = 1000;
                break;
            default:
                res = 0;
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        String x = "XLV";
        System.out.println("romanToInt(" + x + ") = " + new RomanToInteger().romanToInt(x));
    }
}
