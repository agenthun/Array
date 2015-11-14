package com.agenthun.movetosiliconvalley;

import java.util.HashMap;

/**
 * Created by agenthun on 15/11/14.
 */
public class MinWindow {
    String minWindow(String s, String t) {
        if (t == null || t.length() == 0) return "";
        int sLen = s.length(), tLen = t.length();
        HashMap<Character, Integer> toFind = new HashMap<>();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            if (toFind.containsKey(c)) {
                toFind.put(c, toFind.get(c) + 1);
            } else {
                toFind.put(c, 1);
            }
        }

        HashMap<Character, Integer> hasFound = new HashMap<>();
        int count = 0, start = 0, minLen = Integer.MAX_VALUE, minLenStart = -1;
        for (int i = 0; i < sLen; i++) {
            char ch = s.charAt(i);
            if (!toFind.containsKey(ch)) continue;
            if (hasFound.containsKey(ch)) {
                hasFound.put(ch, hasFound.get(ch) + 1);
            } else {
                hasFound.put(ch, 1);
            }
            if (hasFound.get(ch) <= toFind.get(ch)) {
                count++;
            }

            if (count >= tLen) {
                char c = s.charAt(start);
                while (hasFound.containsKey(c) == false || hasFound.get(c) > toFind.get(c)) {
                    if (hasFound.containsKey(c)) hasFound.put(c, hasFound.get(c) - 1);
                    start++;
                    c = s.charAt(start);
                }
                int len = i - start + 1;
                if (len < minLen) {
                    minLen = len;
                    minLenStart = start;
                }
            }
        }

        if (minLenStart >= 0) return s.substring(minLenStart, minLenStart + minLen);
        else return "";
    }

    public static void main(String[] args) {
        String s = "afegcabc";
        String t = "face";
        System.out.println("s = " + s);
        System.out.println("t = " + t);
        System.out.println("minWindow(s,t) = " + new MinWindow().minWindow(s, t));
    }
}
