package com.agenthun.leetcode;

/**
 * Created by agenthun on 15/9/29.
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println("m = " + m);
        System.out.println("n = " + n);
        System.out.println("uniquePaths(m,n) = " + new UniquePaths().uniquePaths(m, n));
    }
}
