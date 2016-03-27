package com.agenthun.schoolrecruit2016;

import java.util.Stack;

/**
 * Created by agenthun on 16/3/27.
 * 有一个直方图，用一个整数数组表示，其中每列的宽度为1，求所给直方图包含的最大矩形面积。
 * 比如，对于直方图[2,7,9,4],它所包含的最大矩形的面积为14(即[7,9]包涵的7x2的矩形)。
 * 给定一个直方图A及它的总宽度n，请返回最大矩形面积。保证直方图宽度小于等于500。保证结果在int范围内。
 * 测试样例：[2,7,9,4,1],5
 * 返回：14
 */
public class MaxInnerRec {
    public int countArea(int[] A, int n) {
        // write code here
        int max = 0;
        Stack<Integer> bars = new Stack<>();
        bars.add(-1);
        for (int i = 0; i < n; i++) {
            int prev = bars.peek();
            if (prev < 0 || A[i] >= A[prev]) {
                bars.add(i);
            } else {
                prev = bars.pop();
                max = Math.max(max, A[prev] * (i - bars.peek() - 1));
                i--;
            }
        }

        while (bars.peek() != -1) {
            int prev = bars.pop();
            max = Math.max(max, A[prev] * (n - bars.peek() - 1));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 9, 4, 1};
        int n = 5;
        System.out.println("countArea(a,n) = " + new MaxInnerRec().countArea(a, n));
    }
}
