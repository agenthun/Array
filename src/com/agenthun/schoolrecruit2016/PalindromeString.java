package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/6/26.
 * 给定一个字符串，问是否能通过添加一个字母将其变为回文串。
 * 输入描述:
 * 一行一个由小写字母构成的字符串，字符串长度小于等于10。
 * 输出描述:
 * 输出答案(YES\NO).
 * 输入例子:
 * coco
 * 输出例子:
 * YES
 */
public class PalindromeString {
    //判断原字符串和翻转字符串的最长公共子序列长度是否比原字符串长度小1或相等
    private static int lcs(String str1, String str2) {
        if (str1 == null || str2 == null) return 0;
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i < n; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String reverseStr = new StringBuffer(str).reverse().toString();
            int len = lcs(str, reverseStr);
            if (str.length() - len <= 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
