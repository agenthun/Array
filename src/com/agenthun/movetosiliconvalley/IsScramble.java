package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/10/5.
 */
public class IsScramble {
    boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (s2.length() != n) return false;
        boolean[][][] dp = new boolean[n][n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int l = 1; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                for (int j = 0; j + l < n; j++) {
                    for (int k = 0; k < l; k++) {
                        if ((dp[i][j][k] && dp[i + k + 1][j + k + 1][l - 1 - k])
                                || (dp[i][j + l - k][k] && dp[i + k + 1][j][l - 1 - k])) {
                            dp[i][j][l] = true;
                            break;
                        }
                    }
                }
            }
        }

        return dp[0][0][n - 1];
    }

    public static void main(String[] args) {
        String s1 = "girl";
        String s2 = "igrl";
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("isScramble(s1, s2) = " + new IsScramble().isScramble(s1, s2));
    }
}
