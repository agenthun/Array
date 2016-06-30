package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/6/30.
 * 在N*M的草地上,提莫种了K个蘑菇,蘑菇爆炸的威力极大,兰博不想贸然去闯,而且蘑菇是隐形的.
 * 只有一种叫做扫描透镜的物品可以扫描出隐形的蘑菇,于是他回了一趟战争学院,买了2个扫描透镜,
 * 一个扫描透镜可以扫描出(3*3)方格中所有的蘑菇,然后兰博就可以清理掉一些隐形的蘑菇.
 * 问:兰博最多可以清理多少个蘑菇?
 * 注意：每个方格被扫描一次只能清除掉一个蘑菇。
 * 输入描述:
 * 第一行三个整数:N,M,K,(1≤N,M≤20,K≤100),N,M代表了草地的大小;
 * 接下来K行,每行两个整数x,y(1≤x≤N,1≤y≤M).代表(x,y)处提莫种了一个蘑菇.
 * 一个方格可以种无穷个蘑菇.
 * 输出描述:
 * 输出一行,在这一行输出一个整数,代表兰博最多可以清理多少个蘑菇.
 */
public class ScanMirror {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int K = scanner.nextInt();
            int[][] matrix = new int[N + 1][M + 1];
            for (int i = 0; i < K; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                matrix[x][y]++;
            }

            int max = findMax(matrix);
            int secondMax = findMax(matrix);
            System.out.println(max + secondMax);
        }
    }

    private static int findMax(int[][] matrix) {
        int max = 0;
        int maxX = 0, maxY = 0;
        int num = 0;
        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix[0].length - 1; j++) {
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int m = j - 1; m <= j + 1; m++) {
                        if (matrix[k][m] > 0) num++;
                    }
                }

                if (num > max) {
                    max = num;
                    maxX = i;
                    maxY = j;
                }
                num = 0;
            }
        }

        for (int i = maxX - 1; i <= maxX + 1; i++) {
            for (int j = maxY - 1; j <= maxY + 1; j++) {
                if (matrix[i][j] > 0)
                    matrix[i][j] = matrix[i][j] - 1;
            }
        }
        return max;
    }
}
