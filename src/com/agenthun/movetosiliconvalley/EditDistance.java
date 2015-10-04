package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/10/4.
 */
public class EditDistance {
    int editDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(i - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        String a = "abcd";
        String b = "adbxcde";
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("editDistance(a,b) = " + new EditDistance().editDistance(a, b));
    }
}
