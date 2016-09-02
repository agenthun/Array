package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/9/2.
 * 求完全平方数和为n的个数
 * 给一个正整数 n, 找到若干个完全平方数(比如1, 4, 9, ... )使得他们的和等于 n。你需要让平方数的个数最少。
 * 给出 n = 12, 返回 3 因为 12 = 4 + 4 + 4。
 * 给出 n = 13, 返回 2 因为 13 = 4 + 9
 */
public class PerfectSquareSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int res = getCount(n);
            System.out.println(res);
        }
    }


    private static int getCount(int n) {
        int nSqrt = (int) Math.floor(Math.sqrt(n));

        if (nSqrt * nSqrt == n) {
            return 1;
        }

        //列出所有可能的完全平方数
        int[] perfectSquareArray = new int[nSqrt];
        for (int i = 1; i <= nSqrt; i++) {
            perfectSquareArray[i - 1] = i * i;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        //初始化dp
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < nSqrt; j++) {
                if (perfectSquareArray[j] <= i) {
                    int sum = dp[i - perfectSquareArray[j]];
                    if (sum != Integer.MAX_VALUE && sum + 1 < dp[i]) {
                        dp[i] = sum + 1;
                    }
                }
            }
        }
        return dp[n];
    }
}
