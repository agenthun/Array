package com.agenthun.schoolrecruit2016;

/**
 * Created by agenthun on 16/4/3.
 * 对于一个无序数组A，请设计一个算法，求出需要排序的最短子数组的长度。
 * 给定一个整数数组A及它的大小n，请返回最短子数组的长度。
 * 测试样例：
 * [1,5,3,4,2,6,7],7
 * 返回：4
 */
public class ShortSubsequence {
    public int findShortest(int[] A, int n) {
        // write code here
        int maxIndex = -1;
        int max = A[0];
        for (int i = 1; i < n; i++) {
            if (max > A[i])
                maxIndex = i;
            else
                max = A[i];
        }
        if (maxIndex == -1) return 0;

        int minIndex = -1;
        int min = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (min < A[i])
                minIndex = i;
            else
                min = A[i];
        }
        return maxIndex - minIndex + 1;
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 3, 4, 2, 6, 7};
        int n = 7;
        System.out.println("findShortest(a,n) = " + new ShortSubsequence().findShortest(a, n));
    }
}
