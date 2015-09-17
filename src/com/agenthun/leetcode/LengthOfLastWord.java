package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/9/18.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int result = 0;
        int i;
        s = s.trim();
        if (s == null || s.length() < 1) return result;
        for (i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) == ' ') {
                result = s.length() - 1 - i;
                break;
            }
        }
        if (i == 0)
            return s.length();
        else
            return result;
    }

    public static void main(String[] args) {
        String s = "a";
        System.out.println(s);
        System.out.println("lengthOfLastWord(s) = " + new LengthOfLastWord().lengthOfLastWord(s));
    }
}
