package com.agenthun.nowcoder;

import java.util.ArrayList;

/**
 * Created by agenthun on 16/2/1.
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        int xBegin = 0, xEnd = matrix.length - 1;
        int yBegin = 0, yEnd = matrix[0].length - 1;

        while (true) {
            for (int i = yBegin; i <= yEnd; i++) {
                result.add(matrix[xBegin][i]);
            }
            if (++xBegin > xEnd) break;

            for (int i = xBegin; i <= xEnd; i++) {
                result.add(matrix[i][yEnd]);
            }
            if (yBegin > --yEnd) break;

            for (int i = yEnd; i >= yBegin; i--) {
                result.add(matrix[xEnd][i]);
            }
            if (xBegin > --xEnd) break;

            for (int i = xEnd; i >= xBegin; i--) {
                result.add(matrix[i][yBegin]);
            }
            if (++yBegin > yEnd) break;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] m = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }

        ArrayList<Integer> result = new PrintMatrix().printMatrix(m);
        for (Integer x :
                result) {
            System.out.print(x + " ");
        }
    }
}
