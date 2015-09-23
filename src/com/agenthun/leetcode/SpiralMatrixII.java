package com.agenthun.leetcode;

/**
 * Created by agenthun on 15/9/24.
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n <= 0) return result;
        if (n == 1) return new int[][]{new int[]{1}};
        int total = n * n;
        int x = 0, y = 0, step = 0;
        for (int i = 0; i < total; ) {
            while (y + step < n) {
                i++;
                result[x][y] = i;
                y++;
            }
            y--;
            x++;

            while (x + step < n) {
                i++;
                result[x][y] = i;
                x++;
            }
            x--;
            y--;

            while (y >= step) {
                i++;
                result[x][y] = i;
                y--;
            }
            y++;
            x--;

            step++;

            while (x >= step) {
                i++;
                result[x][y] = i;
                x--;
            }
            x++;
            y++;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("n = " + n);
        int[][] result = new SpiralMatrixII().generateMatrix(n);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.printf(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
