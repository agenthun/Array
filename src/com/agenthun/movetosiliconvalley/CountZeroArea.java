package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/11/7.
 */
public class CountZeroArea {
    int countZeroArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 0) {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int x, int y, int[][] visited) {
        if (visited[x][y] != 0) return;
        visited[x][y] = 1;
        //up
        if (x > 0 && visited[x - 1][y] == 0 && grid[x - 1][y] == 0)
            dfs(grid, x - 1, y, visited);
        //down
        if (x < grid.length - 1 && visited[x + 1][y] == 0 && grid[x + 1][y] == 0)
            dfs(grid, x + 1, y, visited);
        //left
        if (y > 0 && visited[x][y - 1] == 0 && grid[x][y - 1] == 0)
            dfs(grid, x, y - 1, visited);
        //right
        if (y < grid[0].length - 1 && visited[x][y + 1] == 0 && grid[x][y + 1] == 0)
            dfs(grid, x, y + 1, visited);
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {1, 0, 1, 1, 1}
        };
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("countZeroArea(grid) = " + new CountZeroArea().countZeroArea(grid));
    }
}
