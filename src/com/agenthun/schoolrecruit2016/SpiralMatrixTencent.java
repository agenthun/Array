package com.agenthun.schoolrecruit2016;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by agenthun on 16/8/28.
 * 旋转矩阵
 * 1 2 3
 * 8 9 4
 * 7 6 5
 * 输入I
 * 3
 * 输出
 * 1 2 3 8 9 4 7 6 5
 */
public class SpiralMatrixTencent {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        int beginX = 0;
        int endX = matrix[0].length - 1;
        int beginY = 0;
        int endY = matrix.length - 1;

        while (true) {
            for (int i = beginX; i <= endX; ++i) {
                result.add(matrix[beginY][i]);
            }
            if (++beginY > endY) break;

            for (int i = beginY; i <= endY; ++i) {
                result.add(matrix[i][endX]);
            }
            if (beginX > --endX) break;

            for (int i = endX; i >= beginX; --i) {
                result.add(matrix[endY][i]);
            }
            if (beginY > --endY) break;

            for (int i = endY; i >= beginY; --i) {
                result.add(matrix[i][beginX]);
            }
            if (++beginX > endX) break;
        }

        return result;
    }

    public static int[][] spiralOrder(int n) {
        int[][] result = new int[n][n];
        if (n <= 0) return result;

        int num = 1;
        int beginX = 0;
        int endX = n - 1;
        int beginY = 0;
        int endY = n - 1;

        while (true) {
            for (int i = beginX; i <= endX; ++i) {
                result[i][beginY] = num++;
            }
            if (++beginY > endY) break;

            for (int i = beginY; i <= endY; ++i) {
                result[endX][i] = num++;
            }
            if (beginX > --endX) break;

            for (int i = endX; i >= beginX; --i) {
                result[i][endY] = num++;
            }
            if (beginY > --endY) break;

            for (int i = endY; i >= beginY; --i) {
                result[beginX][i] = num++;
            }
            if (++beginX > endX) break;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[][] matrix = spiralOrder(n);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print(matrix[j][i] + " ");
                }
            }
        }
    }
}
