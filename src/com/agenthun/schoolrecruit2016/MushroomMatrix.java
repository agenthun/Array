package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/5/4.
 * 现在有两个好友A和B，住在一片长有蘑菇的由n＊m个方格组成的草地，A在(1,1),B在(n,m)。
 * 现在A想要拜访B，由于她只想去B的家，所以每次她只会走(i,j+1)或(i+1,j)这样的路线，在草地上有k个蘑菇种在格子里(多个蘑菇可能在同一方格),
 * 问：A如果每一步随机选择的话(若她在边界上，则只有一种选择)，那么她不碰到蘑菇走到B的家的概率是多少？
 * 输入描述:
 * 第一行N，M，K(2 ≤ N,M ≤ 20, k ≤ 100),N,M为草地大小，接下来K行，每行两个整数x，y，代表(x,y)处有一个蘑菇。
 * 输出描述:
 * 输出一行，代表所求概率(保留到2位小数)
 * 输入例子:
 * 2 2 1
 * 2 1
 * 输出例子:
 * 0.50
 */
public class MushroomMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] map = new int[n][m];
            for (int i = 0; i < k; i++) {
                int x = scanner.nextInt() - 1;
                int y = scanner.nextInt() - 1;
                map[x][y] = 1;
            }

            double[][] dp = new double[n][m];
            dp[0][0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1) dp[i][j] = 0;
                    else if (i == 0 && j == 0) {
                    } else {
                        dp[i][j] = (j - 1 < 0 ? 0 :
                                (i + 1 < n ? dp[i][j - 1] * 0.5 : dp[i][j - 1])) + (i - 1 < 0 ? 0 : (j + 1 < m ? dp[i - 1][j] * 0.5 : dp[i - 1][j]));
                    }
                }
            }
            double res = dp[n - 1][m - 1];
            System.out.println(String.format("%.2f", res));
        }
    }
}
