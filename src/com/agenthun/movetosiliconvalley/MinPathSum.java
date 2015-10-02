package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/10/2.
 */
public class MinPathSum {
    int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] path = new int[m][n];
        path[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            path[i][0] = path[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            path[0][j] = path[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                path[i][j] = Math.min(path[i][j - 1] + grid[i][j], path[i - 1][j] + grid[i][j]);
            }
        }
        return path[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] a = {
                {0, 0, 3},
                {0, 2, 0},
                {1, 0, 0}
        };
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("result");
        System.out.println("minPathSum(a) = " + new MinPathSum().minPathSum(a));
    }
}
