package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/6/16.
 */
public class MinPalinCut {
    public static int lenghOfLCS(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        int n1 = s1.length();
        int n2 = s2.length();
        int[][] table = new int[n1][n2];//所有元素默认初始化为0

        if (ch1[0] == ch2[0]) table[0][0] = 1;

        //单独计算s1[0]的LCS长度
        for (int i = 1; i < n2; ++i) {
            if (ch1[0] == ch2[i])
                table[0][i] = 1;
            else
                table[0][i] = table[0][i - 1];
        }

        //单独计算s2[0]的LCS长度
        for (int i = 1; i < n1; ++i) {
            if (ch2[0] == ch1[i])
                table[i][0] = 1;
            else
                table[i][0] = table[i - 1][0];
        }

        //递推求解各个字符处的LCS
        for (int i = 1; i < n1; ++i) {
            for (int j = 1; j < n2; ++j) {
                if (ch1[i] == ch2[j]) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else
                    table[i][j] = table[i - 1][j] > table[i][j - 1] ? table[i - 1][j] : table[i][j - 1];
            }
        }
        return table[n1 - 1][n2 - 1];
    }

    private static int getResult(String str) {
        StringBuilder stringBuilder = new StringBuilder(str).reverse();

        int len = str.length();
        int[][] dp = new int[len][len];

        if (str.charAt(0) == stringBuilder.charAt(0)) dp[0][0] = 1;

        for (int i = 1; i < len; i++) {
            if (str.charAt(0) == stringBuilder.charAt(i)) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i < len; i++) {
            if (str.charAt(i) == stringBuilder.charAt(0)) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j < len; j++) {
                if (str.charAt(i) == stringBuilder.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][0] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[len - 1][len - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int len = lenghOfLCS(str, new StringBuffer(str).reverse().toString());
            System.out.println(str.length() - len);
        }
    }
}
