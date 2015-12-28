package com.agenthun.leetcode;

/**
 * Created by agenthun on 15/12/28.
 */
public class ReverseBits {
    int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            if ((n & 1) == 1) {
                result |= 1;
            }
            n = n >> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("n = " + n);
        System.out.println("reverseBits(n) = " + new ReverseBits().reverseBits(n));
    }
}
