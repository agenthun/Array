package com.agenthun.array;

/**
 * Created by Agent Henry on 2015/7/20.
 */
public class FindMaxDiff {
    public static int max(int m, int n) {
        return m > n ? m : n;
    }

    private static int findMaxDiff(int[] a) {
        if (a == null || a.length <= 1) return Integer.MIN_VALUE;
        int len = a.length;
        int[] diff = new int[len];
        int[] max = new int[len];
        diff[0] = 0;
        max[0] = a[0];
        for (int i = 1; i < len; i++) {
            diff[i] = max(diff[i - 1], max[i - 1] - a[i]);
            max[i] = max(max[i - 1], a[i]);
        }
        return diff[len - 1];
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 17, 3, 2, 9};
        System.out.println("max diff = " + findMaxDiff(a));
    }
}
