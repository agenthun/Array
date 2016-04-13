package com.agenthun.schoolrecruit2016;

/**
 * Created by agenthun on 16/4/14.
 * 对于一个数字序列，请设计一个复杂度为O(nlogn)的算法，返回该序列的最长上升子序列的长度，
 * 这里的子序列定义为这样一个序列U1，U2...，其中Ui < Ui+1，且A[Ui] < A[Ui+1]。
 * 给定一个数字序列A及序列的长度n，请返回最长上升子序列的长度。
 * 测试样例：
 * [2,1,4,3,1,5,6],7
 * 返回：4
 */
public class AscentSequence {
    public static int findLongest(int[] A, int n) {
        int[] dp = new int[n];
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (A[i] > A[j]) {
                    dp[i] = dp[j] + 1 > dp[i] ? (dp[j] + 1) : dp[i];
                }
            }
            if (maxCount < dp[i]) maxCount = dp[i];
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 4, 3, 1, 5, 6};
        int n = 7;
        System.out.println("findLongest(a,n) = " + findLongest(a, n));
    }
}
