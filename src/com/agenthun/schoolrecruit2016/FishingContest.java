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
            String[] input = scanner.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int x = Integer.parseInt(input[2]);
            int y = Integer.parseInt(input[3]);
            int t = Integer.parseInt(input[4]);

            double pCC = 0;
            double pSum = 0;

            for (int i = 1; i <= n; i++) {
                String[] s = scanner.nextLine().split(" ");
                for (int j = 1; j <= m; j++) {
                    double p = Double.parseDouble(s[j - 1]);
                    pSum += p;
                    if (i == x && j == y) {
                        pCC = p;
                    }
                }
            }

            double pSS = pSum / (n * m);

            //!注意这里:t个独立事件:P(t1Ut2Ut3..Utn) = 1-P(非t1)P(非t2)...P(非t3)
            if (pSS == pCC) {
                System.out.println("equal");
                System.out.println(String.format("%.2f", 1 - Math.pow(1 - pCC, t)));
            } else if (pSS > pCC) {
                System.out.println("ss");
                System.out.println(String.format("%.2f", 1 - Math.pow(1 - pSS, t)));
            } else if (pSS < pCC) {
                System.out.println("cc");
                System.out.println(String.format("%.2f", 1 - Math.pow(1 - pCC, t)));
            }
        }
    }
}
