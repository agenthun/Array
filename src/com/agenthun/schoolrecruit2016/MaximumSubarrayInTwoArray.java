package com.agenthun.schoolrecruit2016;

/**
 * Created by agenthun on 16/7/27.
 * 求两个数组中最大累加和
 * L(i) 0 ~ i最大累加和
 * R(i) n-1 ~ i最大累加和
 */
public class MaximumSubarrayInTwoArray {
    int maxSum(int[] a) {
        if (a == null || a.length < 2) return 0;

        int[] h = new int[a.length];
        h[a.length - 1] = a[a.length - 1];
        int cur = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            cur = cur < 0 ? 0 : cur;
            cur += a[i];
            h[i] = Math.max(h[i + 1], cur);
        }

        int res = a[0] + h[1];
        int lmax = a[0];
        cur = a[0];
        for (int i = 1; i < a.length - 1; i++) {
            cur = cur < 0 ? 0 : cur;
            cur += a[i];
            lmax = Math.max(lmax, cur);
            res = Math.max(res, lmax + h[i + 1]);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
