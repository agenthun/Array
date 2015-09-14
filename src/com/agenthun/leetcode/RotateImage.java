package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/9/15.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int m = matrix.length;
        for (int i = 0; i < (m >> 1); i++) {
            for (int j = 0; j < Math.ceil(((double) m) / 2); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m - 1 - j][i];
                matrix[m - 1 - j][i] = matrix[m - 1 - i][m - 1 - j];
                matrix[m - 1 - i][m - 1 - j] = matrix[j][m - 1 - i];
                matrix[j][m - 1 - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("rotate(a)");
        new RotateImage().rotate(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
