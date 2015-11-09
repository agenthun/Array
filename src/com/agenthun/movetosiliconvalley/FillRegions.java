package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/11/9.
 */
public class FillRegions {
    void fillRegions(char[][] board) {
        if (board == null) return;

        int m = board.length;
        int n = board[0].length;
        //top
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'o')
                dfs(board, 0, i);
        }
        //right
        for (int i = 1; i < m; i++) {
            if (board[i][n - 1] == 'o')
                dfs(board, i, n - 1);
        }
        //bottom
        for (int i = 0; i < n - 1; i++) {
            if (board[m - 1][i] == 'o')
                dfs(board, m - 1, i);
        }
        //left
        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'o')
                dfs(board, i, 0);
        }

        //inner
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'o')
                    board[i][j] = 'x';
                else if (board[i][j] == '#')
                    board[i][j] = 'o';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        board[i][j] = '#';
        //up
        if (i - 1 >= 0 && board[i - 1][j] == 'o')
            dfs(board, i - 1, j);
        //right
        if (j < board[0].length - 1 && board[i][j + 1] == 'o')
            dfs(board, i, j + 1);
        //down
        if (i < board.length - 1 && board[i + 1][j] == 'o')
            dfs(board, i + 1, j);
        //left
        if (j >= 1 && board[i][j - 1] == 'o')
            dfs(board, i, j - 1);
    }

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'x', 'x', 'x'},
                {'x', 'o', 'o', 'x'},
                {'o', 'x', 'o', 'x'},
                {'o', 'x', 'x', 'x'}
        };
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        new FillRegions().fillRegions(board);
        System.out.println("result");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
