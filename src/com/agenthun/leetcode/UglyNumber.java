package com.agenthun.leetcode;

/**
 * Created by agenthun on 15/12/24.
 */
public class UglyNumber {
    boolean isUgly(int num) {
        if (num <= 0) return false;
        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        if (num == 1) return true;
        else return false;
    }

    public static void main(String[] args) {
        int n = 6, m = 14;
        System.out.println("n = " + n);
        System.out.println("isUgly(n) = " + new UglyNumber().isUgly(n));
        System.out.println("m = " + m);
        System.out.println("isUgly(m) = " + new UglyNumber().isUgly(m));
    }
}
