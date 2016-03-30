package com.agenthun.schoolrecruit2016;

/**
 * Created by agenthun on 16/3/30.
 * 有一个二维数组(n*n),写程序实现从右上角到左下角沿主对角线方向打印。
 * 给定一个二位数组arr及题目中的参数n，请返回结果数组.
 * 测试样例：
 * [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]],4
 * 返回：
 * [4,3,8,2,7,12,1,6,11,16,5,10,15,9,14,13]
 */
public class Printer {
    public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int[] res = new int[n * n];
        if (arr == null || arr.length == 0) return res;

        int k = 0;

        for (int j = n - 1; j >= 0; j--) {
            int x = 0;
            int y = j;
            while (x < n && y < n) {
                res[k++] = arr[x++][y++];
            }
        }

        for (int i = 1; i < n; i++) {
            int x = i;
            int y = 0;
            while (x < n && y < n) {
                res[k++] = arr[x++][y++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int n = 4;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        int[] res = new Printer().arrayPrint(arr, n);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
