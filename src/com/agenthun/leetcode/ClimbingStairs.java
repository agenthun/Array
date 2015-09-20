package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/9/20.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("n = " + n);
        System.out.println("climbStairs(n) = " + new ClimbingStairs().climbStairs(n));
    }
}
