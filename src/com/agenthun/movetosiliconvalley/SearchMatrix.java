package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/10/20.
 */
public class SearchMatrix {
    boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int i = mid / n;
            int j = mid % n;
            if (target < matrix[i][j]) right = mid - 1;
            else if (target > matrix[i][j]) left = mid + 1;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] m = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        int target = 7;
        System.out.println("target = " + target);
        System.out.println("searchMatrix(m,target) = " + new SearchMatrix().searchMatrix(m, target));
        target = 0;
        System.out.println("target = " + target);
        System.out.println("searchMatrix(m,target) = " + new SearchMatrix().searchMatrix(m, target));
    }
}
