package com.agenthun.nowcoder;

/**
 * Created by agenthun on 16/2/10.
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 */
public class StrToInt {
    public int StrToInt(String str) {
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
        if (i < str.length()) return 0; //不同于(#leetcode - StringToInteger)

        if (flag == '-') result = -result;
        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) result;
    }
}
