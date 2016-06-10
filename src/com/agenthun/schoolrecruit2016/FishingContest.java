package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/6/10.
 * ss请cc来家里钓鱼，鱼塘可划分为n＊m的格子，每个格子每分钟有不同的概率钓上鱼，cc一直在坐标(x,y)的格子钓鱼，
 * 而ss每分钟随机钓一个格子。问t分钟后他们谁至少钓到一条鱼的概率大？为多少？
 * 输入描述:
 * 第一行五个整数n,m,x,y,t(1≤n,m,t≤1000,1≤x≤n,1≤y≤m);
 * 接下来为一个n＊m的矩阵，每行m个一位小数，共n行，第i行第j个数代表坐标为(i,j)的格子钓到鱼的概率为p(0≤p≤1)
 * 输出描述:
 * 输出两行。第一行为概率大的人的名字(cc/ss/equal),第二行为这个概率(保留2位小数)
 * 输入例子:
 * 2 2 1 1 1
 * 0.2 0.1
 * 0.1 0.4
 * 输出例子:
 * equal
 * 0.20
 */
public class FishingContest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int t = scanner.nextInt();
            double[][] p = new double[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    p[i][j] = scanner.nextDouble();
                }
            }

            double pCC = p[x - 1][y - 1];
            double pSum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    pSum += p[i][j];
                }
            }
            double pSS = pSum / (n * m);

            //!注意这里:t个独立事件:P(t1Ut2Ut3..Utn) = 1-P(非t1)P(非t2)...P(非t3)
            if (pSS == pCC) {
                System.out.println("equal");
                double px = 1 - Math.pow(1 - pCC, t);
                System.out.println(String.format("%.2f", px));
            } else if (pSS > pCC) {
                System.out.println("SS");
                double px = 1 - Math.pow(1 - pSS, t);
                System.out.println(String.format("%.2f", px));
            } else if (pSS < pCC) {
                System.out.println("CC");
                double px = 1 - Math.pow(1 - pCC, t);
                System.out.println(String.format("%.2f", px));
            }
        }
    }
}
