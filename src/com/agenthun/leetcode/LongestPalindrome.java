package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/8/12.
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null) return null;
        if (s.length() <= 1) return s;

        int longestBegin = 0;
        int maxLen = 1;
        int N = s.length();
        boolean[][] isPalindrome = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            isPalindrome[i][i] = true;
        }

        for (int i = 0; i < N - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
                longestBegin = i;
                maxLen = 2;
            }
        }

        for (int len = 3; len <= N; len++) {
            for (int i = 0; i < N - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1]) {
                    isPalindrome[i][j] = true;
                    longestBegin = i;
                    maxLen = len;
                }
            }
        }
        return s.substring(longestBegin, maxLen - longestBegin);
    }

    public static void main(String[] args) {
        String str = "abcbabb";
        System.out.println(str);
        System.out.println(new LongestPalindrome().longestPalindrome(str));
    }
}
