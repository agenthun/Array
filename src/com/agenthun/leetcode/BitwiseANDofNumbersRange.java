package com.agenthun.leetcode;

/**
 * Created by agenthun on 16/1/8.
 */
public class BitwiseANDofNumbersRange {
    public static int rangeBitwiseAnd(int m, int n) {
        while (n > m) {
            n = n & n - 1;
        }
        return m & n;
    }

    public static void main(String[] args) {
        int m = 5;
        int n = 7;
        System.out.println("m = " + m);
        System.out.println("n = " + n);
        System.out.println("rangeBitwiseAnd(m,n) = " + rangeBitwiseAnd(m, n));
    }
}
