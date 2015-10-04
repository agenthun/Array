package com.agenthun.leetcode;

/**
 * Created by agenthun on 15/10/4.
 */
public class IsAppear {
    boolean isAppear(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;
        boolean[] dp = new boolean[len1 + 1];
        dp[0] = true;

        for (int i = 0, j = 0; i < len1 + 1; i++) {
            if (dp[i] || i + j - 1 >= 0 && i + j - 1 < len2 && dp[i - 1] == true && s1.charAt(i - 1) == s2.charAt(i + j - 1))
                dp[i] = true;
            else {
                if (i + j - 1 < len2) {
                    j++;
                    i--;
                }
            }
        }

        return dp[len1];
    }

    public static void main(String[] args) {
        String a = "abcd";
        String b = "axbecrd";
        String c = "abc";
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("isAppear(a, b) = " + new IsAppear().isAppear(a, b));
        System.out.println("isAppear(a,c) = " + new IsAppear().isAppear(a, c));
    }
}
