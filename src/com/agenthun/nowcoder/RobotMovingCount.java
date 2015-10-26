package com.agenthun.nowcoder;

/**
 * Created by agenthun on 15/10/26.
 */
public class RobotMovingCount {
    public int movingCount(int threshold, int rows, int cols) {
        int[][] flag = new int[rows][cols];

        return helper(0, 0, rows, cols, flag, threshold);
    }

    private int helper(int i, int j, int rows, int cols, int[][] flag, int threshold) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || (numSum(i) + numSum(j) > threshold) || flag[i][j] == 1)
            return 0;
        flag[i][j] = 1;
        return helper(i - 1, j, rows, cols, flag, threshold)
                + helper(i + 1, j, rows, cols, flag, threshold)
                + helper(i, j - 1, rows, cols, flag, threshold)
                + helper(i, j + 1, rows, cols, flag, threshold) + 1;
    }

    private int numSum(int i) {
        if (i == 0) return 0;
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int m = 2;
        int n = 2;
        int k = 1;
        System.out.println("m = " + m + ", n = " + n + ", k = " + k);
        System.out.println("movingCount(k, m, n) = " + new RobotMovingCount().movingCount(k, m, n));
    }
}
