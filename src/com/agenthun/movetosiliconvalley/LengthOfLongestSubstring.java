package com.agenthun.movetosiliconvalley;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by agenthun on 15/11/13.
 */
public class LengthOfLongestSubstring {
    int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start = 0, maxLen = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (hashMap.containsKey(c) && hashMap.get(c) >= start) {
                start = hashMap.get(c) + 1;
            }
            hashMap.put(c, i);
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println("s = " + s);
        System.out.println("lengthOfLongestSubstring(s) = " + new LengthOfLongestSubstring().lengthOfLongestSubstring(s));
    }
}
