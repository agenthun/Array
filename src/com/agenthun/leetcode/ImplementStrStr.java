package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/9/2.
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return 0;
        if (needle.length() == 0) return 0;

        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length()) return -1;

            int m = i;
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) == haystack.charAt(m)) {
                    if (j == needle.length() - 1) return i;
                    m++;
                } else {
                    break;
                }
            }
        }
        return -1;
    }
/*    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return 0;
        int h = haystack.length();
        int n = needle.length();
        if (h < n) return -1;
        if (n == 0) return 0;

        int[] next = getNext(needle);
        int i = 0;
        while (i <= h - n) {
            int success = 1;
            for (int j = 0; j < n; j++) {
                if (needle.charAt(0) != haystack.charAt(i)) {
                    success = 0;
                    i++;
                    break;
                } else if (needle.charAt(j) != haystack.charAt(i)) {
                    success = 0;
                    i = i + j - next[j - 1];
                    break;
                }
            }
            if (success == 1) return i;
        }
        return -1;
    }*/

    private int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        next[0] = 0;
        for (int i = 1; i < needle.length(); i++) {
            int index = next[i - 1];
            while (index > 0 && needle.charAt(index) != needle.charAt(i)) {
                index = next[index - 1];
            }
            if (needle.charAt(index) == needle.charAt(i)) {
                next[i] = next[i - 1] + 1;
            } else {
                next[i] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String src = "bhjlabcs";
        String des = "abc";
        System.out.println("src = " + src);
        System.out.println("des = " + des);
        System.out.println("strStr(src, des) = " + new ImplementStrStr().strStr(des, des));
    }
}
