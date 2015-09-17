package com.agenthun.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agent Henry on 2015/9/17.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
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

    public static void main(String[] args) {
        int[][] m = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        List<Integer> result = new SpiralMatrix().spiralOrder(m);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}
