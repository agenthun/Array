package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/10/5.
 */
public class MinPalinCut {
    int minPalinCut(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        boolean[][] isPa = new boolean[len][len];

        for (int i = 0; i <= len; i++) {
            dp[i] = len - i - 1;
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isPa[i + 1][j - 1])) {
                    isPa[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String s = "abcda";
        System.out.println("s = " + s);
        System.out.println("minPalinCut(s) = " + new MinPalinCut().minPalinCut(s));
    }
}
