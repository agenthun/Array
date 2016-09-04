package com.agenthun.schoolrecruit2016;

import java.util.HashMap;

/**
 * Created by agenthun on 16/9/4.
 * 最大子矩阵和, n*n矩阵时: 时间复杂度O(n)*O(n)*O(n)
 * m*n矩阵时: 时间复杂度O(m)*O(m)*O(n)
 * 行分别对列累加:
 * 先算第1行, 算第1,2行, 算第1,2,3行..;分别求最大子数组和
 * 先算第2行, 算第2,3行, 算第2,3,4行..;分别求最大子数组和
 */
public class MaximumSubMatrixSum {
    //求最小子矩阵和
    public static int subMatrixSum(int[][] a) {
        if (a == null || a.length == 0) return Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            int[] sumCol = new int[a[0].length]; //对列累加和形成的数组

            for (int j = i; j < a.length; j++) {
                int sum = 0;
                for (int k = 0; k < a[0].length; k++) {
                    sumCol[k] += a[j][k]; //更新对列累加和形成的数组

                    //算法原型: 求最大子数组和
                    sum += sumCol[k];
                    sum = sum < 0 ? 0 : sum;
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }

    //求子矩阵和小于等于K的最大子矩阵的大小
    public static int subMatrixKSumMaxCount(int[][] a, int K) {
        if (a == null || a.length == 0) return Integer.MIN_VALUE;
        int maxCount = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            int[] sumCol = new int[a[0].length]; //对列累加和形成的数组

            for (int j = i; j < a.length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    sumCol[k] += a[j][k]; //更新对列累加和形成的数组
                }
                //算法原型: 求子数组和小于等于K的最长子数组 maxLength
                maxCount = Math.max(maxCount, (j - i + 1) * maxLength(sumCol, K)); //算矩阵大小(j - i + 1) * (k + 1)
            }
        }
        return maxCount;
    }

    //求子数组和小于等于K的最长子数组
    private static int maxLength(int[] a, int k) {
        int[] h = new int[a.length + 1];
        int sum = 0;
        h[0] = sum;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            h[i + 1] = Math.max(h[i], sum);
        }

        sum = 0;
        int res = 0;
        int pre = 0;
        int len = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            pre = getLessIndex(h, sum - k); //二分法求最早出现位置
            len = pre == -1 ? 0 : i - pre + 1;
            res = Math.max(res, len);
        }
        return res;
    }

    //二分法判断小于等于k最早出现位置
    private static int getLessIndex(int[] h, int k) {
        int left = 0;
        int right = h.length - 1;

        int res = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (h[mid] >= k) {
                res = mid;
                break;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] a = {
                {1, -1, 0},
                {-3, -1, 0},
                {4, -1, 0},
        };

        System.out.println("subMatrixSum = " + subMatrixSum(a));
        System.out.println("subMatrixKSumMaxCount = " + subMatrixKSumMaxCount(a, -1));
    }
}
