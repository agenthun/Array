package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/10/3.
 */
public class NumDecodings {
    int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') dp[i] = 0;
            else dp[i] = dp[i + 1];

            if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6')))
                dp[i] += dp[i + 2];
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String s = "2613";
        System.out.println("s = " + s);
        System.out.println("numDecodings(s) = " + new NumDecodings().numDecodings(s));
    }
}
