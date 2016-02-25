package com.agenthun.nowcoder;

/**
 * Created by agenthun on 16/2/25.
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class HasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length == 0) return false;

        boolean flag[] = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, str, i, j, 0, flag))
                    return true;
            }
        }
        return false;
    }

    private boolean helper(char[] matrix, int rows, int cols, char[] str, int i, int j, int k, boolean[] flag) {
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == true) {
            return false;
        }
        if (k == str.length - 1) return true;
        flag[index] = true;
        if (helper(matrix, rows, cols, str, i - 1, j, k + 1, flag)
                || helper(matrix, rows, cols, str, i + 1, j, k + 1, flag)
                || helper(matrix, rows, cols, str, i, j - 1, k + 1, flag)
                || helper(matrix, rows, cols, str, i, j + 1, k + 1, flag)) {
            return true;
        }
        flag[index] = false;
        return false;
    }

    public static void main(String[] args) {
        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        int rows = 3;
        int cols = 4;
        char[] str1 = {'b', 'c', 'c', 'e', 'd'};
        char[] str2 = {'a', 'b', 'c', 'b'};
        System.out.println("rows = " + rows);
        System.out.println("cols = " + cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i * cols + j] + " ");
            }
            System.out.println();
        }
        System.out.println("str1 = " + new String(str1));
        System.out.println("str2 = " + new String(str2));

        System.out.println("hasPath(matrix,rows,cols,str1) = " + new HasPath().hasPath(matrix, rows, cols, str1));
        System.out.println("hasPath(matrix,rows,cols,str2) = " + new HasPath().hasPath(matrix, rows, cols, str2));
    }
}
