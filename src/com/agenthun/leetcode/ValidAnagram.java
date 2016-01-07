package com.agenthun.leetcode;

/**
 * Created by agenthun on 16/1/7.
 */
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        int[] table = new int[26];

        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (table[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String r = "art";
        String s = "rat";
        String t = "car";
        System.out.println("r = " + r);
        System.out.println("s = " + s);
        System.out.println("t = " + t);

        System.out.println("isAnagram(s,t) = " + isAnagram(s, t));
        System.out.println("isAnagram(r,s) = " + isAnagram(r, s));
    }
}
