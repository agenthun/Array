package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/9/9.
 * 求回文结构可两两相加
 * 4
 * 1 1 1 3
 */
public class MinPalinCutSum {
    private static int minPalinCut(int[] a) {
        int len = a.length;
        int[] dp = new int[len + 1];
        boolean[][] isPa = new boolean[len + 1][len];

        for (int i = 0; i <= len; i++) {
            dp[i] = len - i - 1;
        }
        for (int i = len - 1; i >= 1; i--) {
            for (int j = i; j < len; j++) {
                //j - i < 2
                if (a[i] == a[j] && (
                        (j - i == 2) && (a[i - 1] + a[i] == a[j])
                                || (j - i == 2) && (a[i - 1] == a[i] + a[j])
                                || isPa[i + 1][j - 1]
                )) {
                    isPa[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0];
    }

    static int[][] dd = new int[5000][5000];

    private static int f(int[] a, int l, int r) {
        if (l >= r) return 0;
        else if (dd[l][r] >= 0) return dd[l][r];//已经计算出来答案
        else {
            if (a[l] == a[r])
                dd[l][r] = f(a, l + 1, r - 1);
            else {
                int temp1 = -1;
                int temp2 = -1;
                if (a[l] + a[l + 1] == a[r]) {
                    temp1 = f(a, l + 1, r);
                }
                if (a[l] == a[r - 1] + a[r]) {
                    temp2 = f(a, l, r - 1);
                }
                if (temp1 != -1 && temp2 != -1) {
                    dd[l][r] = Math.min(temp1, temp2) + 1;
                } else {
                    if (temp1 != -1) {
                        dd[l][r] = temp1 + 1;
                    }
                    if (temp2 != -1) {
                        dd[l][r] = temp2 + 1;
                    }
                }
            }
            return dd[l][r];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = scanner.nextInt();
            }

            System.out.println(minPalinCut(a));
            System.out.println(f(a, 0, a.length - 1));
        }
    }
}
