package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/8/21.
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) return null;
        String[][] roman = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };
        String result = "";
        int i = 0;
        while (num > 0) {
            result = roman[i++][num % 10] + result;
            num /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        int x = 45;
        System.out.println("intToRoman(" + x + ") = " + new IntegerToRoman().intToRoman(x));
    }
}
