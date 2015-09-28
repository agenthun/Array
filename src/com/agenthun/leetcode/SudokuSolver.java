package com.agenthun.leetcode;

/**
 * Created by agenthun on 15/9/28.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solveSudokudfs(board);
    }

    private boolean solveSudokudfs(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (int k = 1; k <= 9; k++) {
                        board[i][j] = (char) ('0' + k);
                        if (isValid(board, i, j) && solveSudokudfs(board))
                            return true;
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int a, int b) {
        for (int i = 0; i < 9; i++) {
            if (i != a && board[i][b] == board[a][b])
                return false;
        }

        for (int j = 0; j < 9; j++) {
            if (j != b && board[a][j] == board[a][b])
                return false;
        }

        int x = a / 3 * 3;
        int y = b / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (x + i != a && y + j != b && board[x + i][y + j] == board[a][b])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("result");
        (new SudokuSolver()).solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
