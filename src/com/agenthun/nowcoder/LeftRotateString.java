package com.agenthun.nowcoder;

import com.agenthun.leetcode.StringToInteger;

/**
 * Created by agenthun on 16/2/7.
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 */
public class LeftRotateString {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0) return "";

        char[] array = str.toCharArray();
        rotate(array, 0, n - 1);
        rotate(array, n, array.length - 1);
        rotate(array, 0, array.length - 1);
        return String.valueOf(array);
    }

    private void rotate(char[] array, int begin, int end) {
        while (begin < end) {
            char temp = array[begin];
            array[begin] = array[end];
            array[end] = temp;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        String s = "abcXYZdef";
        int n = 3;
        System.out.println("s = " + s);
        System.out.println("n = " + n);

        System.out.println("LeftRotateString(s,n) = " + new LeftRotateString().LeftRotateString(s, n));
    }
}
