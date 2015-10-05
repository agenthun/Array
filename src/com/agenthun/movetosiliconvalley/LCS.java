package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/10/5.
 */
public class LCS {
    String LCS(String s1, String s2) {
        String result = "";
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) return result;

        int max = 0, l1 = s1.length(), l2 = s2.length();
        int[][] dp = new int[l1][l2];

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (i == 0 || j == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = dp[i - 1][j - 1] + 1; //dp[i][j]表示相同字符长度

                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        result = s1.substring(i - dp[i][j] + 1, i + 1);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "abbbc";
        String s2 = "axbbcd";
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("LCS(s1, s2) = " + new LCS().LCS(s1, s2));
    }
}
