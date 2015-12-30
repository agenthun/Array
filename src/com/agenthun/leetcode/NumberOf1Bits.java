package com.agenthun.leetcode;

/**
 * Created by agenthun on 15/12/30.
 */
public class NumberOf1Bits {
    int hammingWeight(int n) {
        if (n < 0) return -1;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) result++;
            n = n >> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 11;
        System.out.println("toBinaryString(n) = " + Integer.toBinaryString(n));
        System.out.println("hammingWeight(n) = " + new NumberOf1Bits().hammingWeight(n));
    }
}
