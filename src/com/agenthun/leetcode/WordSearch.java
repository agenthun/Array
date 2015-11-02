package com.agenthun.leetcode;

/**
 * Created by agenthun on 15/11/2.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean result = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        int m = board.length;
        int n = board[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }

        if (board[i][j] == word.charAt(k)) {
            char temp = board[i][j];
            board[i][j] = '#';
            if (k == (word.length() - 1)) {
                return true;
            } else if (dfs(board, word, i - 1, j, k + 1)
                    || dfs(board, word, i + 1, j, k + 1)
                    || dfs(board, word, i, j - 1, k + 1)
                    || dfs(board, word, i, j + 1, k + 1)
                    ) {
                return true;
            }
            board[i][j] = temp;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        String w1 = "ABCCED";
        String w2 = "SEE";
        String w3 = "ABCB";

        System.out.println("w1 = " + w1);
        System.out.println("exist(board,w1) = " + new WordSearch().exist(board, w1));

        System.out.println("w2 = " + w2);
        System.out.println("exist(board,w2) = " + new WordSearch().exist(board, w2));

        System.out.println("w3 = " + w3);
        System.out.println("exist(board,w3) = " + new WordSearch().exist(board, w3));
    }
}
