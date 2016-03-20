package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/3/20.
 */
public class MatrixMultiply {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] matrix = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int res = findMaxMatrixMultiply(matrix);
            System.out.println(res);
        }
    }

    private static int findMaxMatrixMultiply(int[][] matrix) {
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = matrixMultiply(matrix, i, j);
                if (temp > res)
                    res = temp;
            }
        }
        return res;
    }

    private static int matrixMultiply(int[][] matrix, int i, int j) {
        int res = 1;
        for (int row = 0; row < matrix.length; row++) {
            if (row != i) {
                if (matrix[row][j] == 0) return 0;
                res *= matrix[row][j];
            }
        }
        for (int col = 0; col < matrix[0].length; col++) {
            if (col != j) {
                if (matrix[i][col] == 0) return 0;
                res *= matrix[i][col];
            }
        }
        return res;
    }
}
