package com.agenthun.schoolrecruit2016;

/**
 * Created by agenthun on 16/9/4.
 */
public class MaxLengthSubArray {
    public static int[] lis1(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }

        int[] dp = getdp1(a);
        return generateLIS(a, dp);
    }

    public static int[] getdp1(int[] a) {
        int[] dp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    public static int[] getdp2(int[] a) {
        int[] dp = new int[a.length];
        int[] ends = new int[a.length];
        ends[0] = a[0];
        dp[0] = 1;
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        for (int i = 1; i < a.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (a[i] > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[l] = a[i];
            dp[i] = l + 1;
        }
        return dp;
    }

    public static int[] generateLIS(int[] a, int[] dp) {
        int len = 0;
        int index = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > len) {
                len = dp[i];
                index = i;
            }
        }

        int[] lis = new int[len];
        lis[--len] = a[index];
        for (int i = index; i >= 0; i--) {
            if (a[i] < a[index] && dp[i] == dp[index] - 1) {
                lis[--len] = a[i];
                index = i;
            }
        }
        return lis;
    }
}
