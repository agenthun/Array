package com.agenthun.leetcode;

/**
 * Created by agenthun on 15/9/21.
 */
public class ClimbingStairsII {
    void climbingStairs(int n) {
        for (int i = 0; i < 32 && n > 0; i++) {
            if ((n & 1) > 0) System.out.print("k = " + i + ",");
            n >>= 1;
        }
    }

    public static void main(String[] args) {
        int n = 20;
        System.out.println("n = " + n);
        new ClimbingStairsII().climbingStairs(n);
    }
}
