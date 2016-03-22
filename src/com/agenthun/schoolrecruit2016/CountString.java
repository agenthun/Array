package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/3/18.
 * 求字典序在s1和s2之间的，长度在len1到len2的字符串的个数，结果mod 1000007。
 * 输入描述: 每组数据包涵s1（长度小于100），s2（长度小于100），len1（小于100000），len2（大于len1，小于100000）
 * 输出描述: 输出答案。
 * 输入例子: ab ce 1 2
 * 输出例子: 56
 */
public class CountString {
    private static int countString(String s, int len1, int len2) {
        int count = 0;
        int tail = (len2 - s.length()) > 0 ? s.length() - 1 : len2 - 1;
        if (len2 > s.length()) {
            count += calsubstring(1, len2 - s.length());
        }
        for (int i = tail; i >= 0; i--) {
            int start = (i + 1 - len1) > 0 ? 0 : len1 - (i + 1);
            count += ('z' - s.charAt(i)) * calsubstring(start, len2 - i - 1);
        }
        return count;
    }

    private static int calsubstring(int len1, int len2) {
        int rt = 0;
        rt = (int) (Math.pow(26, len1) * (Math.pow(26, len2 - len1 + 1) - 1) / 25);
        return rt;
    }

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        while (scaner.hasNext()) {
            String s1 = scaner.next();
            String s2 = scaner.next();
            int len1 = scaner.nextInt();
            int len2 = scaner.nextInt();

            int count = countString(s1, len1, len2) - countString(s2, len1, len2) - 1;
            System.out.println(count);
        }
    }
}
