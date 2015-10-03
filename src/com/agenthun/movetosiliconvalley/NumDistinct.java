package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/10/3.
 */
public class NumDistinct {
    int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen == 0 || tLen == 0 || tLen > sLen) return 0;
        int[][] dp = new int[sLen + 1][tLen + 1];

        for (int i = 0; i <= sLen; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[sLen][tLen];
    }

    public static void main(String[] args) {
        String s = "Exampple";
        String t = "Example";
        System.out.println("s = " + s);
        System.out.println("t = " + t);
        System.out.println("numDistinct(s,t) = " + new NumDistinct().numDistinct(s, t));
    }
}
