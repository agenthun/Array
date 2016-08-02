package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/8/1.
 * 地牢逃脱
 * n行m列,'.'表示可通行,'X'表示不可走,在(x0,y0)初始位置,出口在任意通行位置,可走k步,每步有行列步长范围
 * 无法离开输出-1
 * input: n,m; 矩阵; 初始位置; k步; 每一步走法
 * 3
 * . . .
 * . . .
 * . . .
 * 0 1
 * 4
 * 1 0
 * 0 1
 * -1 0
 * 0 -1
 * output:
 * 3
 */
public class MatrixRunAway {
    static int countZeroArea(int[][] grid, int[][] move) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 0) {
                    dfs(grid, i, j, visited, move, 0);
                    count++;
                }
            }
        }
        return count;
    }

    static private void dfs(int[][] grid, int x, int y, int[][] visited, int[][] move, int step) {
        if (step >= move.length) return;
        if (visited[x][y] != 0) return;
        visited[x][y] = 1;

        int stepX = move[step][0];
        int stepY = move[step][1];
        dfs(grid, x + stepX, y + stepY, visited, move, step);
        step++;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] mat = new char[n][m];
            for (int i = 0; i < n; i++) {
//                String tmp = scanner.nextLine().trim();
//                for (int j = 0; j < m && j < tmp.length(); j++) {
//                    mat[i][j] = tmp.charAt(j);
//                }
                for (int j = 0; j < m; j++) {
                    mat[i][j] = scanner.next().charAt(0);
                }
            }

            int x0 = scanner.nextInt();
            int y0 = scanner.nextInt();

            int k = scanner.nextInt();
            int[][] move = new int[k][2];
            for (int i = 0; i < k; i++) {
                move[i][0] = scanner.nextInt();
                move[i][1] = scanner.nextInt();
            }

            int res = 0;
            System.out.println(res);
        }
    }
}
