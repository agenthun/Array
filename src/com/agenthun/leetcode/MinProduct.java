package com.agenthun.leetcode;

/**
 * Created by agenthun on 15/9/25.
 */
public class MinProduct {
    public int minProduct(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = i; j < i + (n - m) + 1; j++) {
                if (j > i) {
                    if (i > 0) dp[i][j] = Math.min(a[i] * b[j] + dp[i - 1][j - 1], dp[i][j - 1]);
                    else dp[i][j] = Math.min(a[i] * b[j], dp[i][j - 1]);
                } else {
                    if (i == 0) dp[i][j] = a[i] * b[j];
                    else dp[i][j] = a[i] * b[j] + dp[i - 1][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[] a = {1, -1};
        int[] b = {1, 2, 3, 4};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
        System.out.println("minProduct(a,b) = " + new MinProduct().minProduct(a, b));
    }
}
