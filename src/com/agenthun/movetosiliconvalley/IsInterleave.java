package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/10/4.
 */
public class IsInterleave {
    boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if (l1 + l2 != l3) return false;
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;

        for (int i = 0; i < l1 + 1; i++) {
            for (int j = 0; j < l2 + 1; j++) {
                if (dp[i][j]
                        || (i - 1 >= 0 && dp[i - 1][j] == true && s2.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (j - 1 >= 0 && dp[i][j - 1] == true && s1.charAt(j - 1) == s3.charAt(i + j - 1)))
                    dp[i][j] = true;
                else
                    dp[i][j] = false;
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        String s1 = "abc", s2 = "def", s31 = "adbecf", s32 = "abcdee";
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("s31 = " + s31);
        System.out.println("s32 = " + s32);
        System.out.println("isInterleave(s1, s2, s31) = " + new IsInterleave().isInterleave(s1, s2, s31));
        System.out.println("isInterleave(s1, s2, s32) = " + new IsInterleave().isInterleave(s1, s2, s32));
    }
}
