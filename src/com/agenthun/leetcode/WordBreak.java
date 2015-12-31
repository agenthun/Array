package com.agenthun.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by agenthun on 15/12/31.
 */
public class WordBreak {
    boolean wordBreak(String s, Set<String> wordDict) {
        //return wordBreakHelper(s, wordDict, 0); // solve 1

        boolean[] t = new boolean[s.length() + 1]; //solve 2 动态规划
        t[0] = true;

        for (int i = 0; i < s.length(); i++) {
            if (!t[i]) continue;

            for (String a :
                    wordDict) {
                int len = a.length();
                int end = i + len;
                if (end > s.length()) continue;

                if (t[end]) continue;

                if (s.substring(i, end).equals(a))
                    t[end] = true;
            }
        }
        return t[s.length()];
    }

    // solve 1
    private boolean wordBreakHelper(String s, Set<String> wordDict, int start) {
        if (start == s.length()) return true;
        for (String a :
                wordDict) {
            int len = a.length();
            int end = start + len;
            if (end > s.length()) continue;

            if (s.substring(start, start + len).equals(a)) {
                if (wordBreakHelper(s, wordDict, start + len))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        Set<String> set = new HashSet<>();
        set.add("leet");
        set.add("code");

        System.out.println("s = " + s);
        for (String a :
                set) {
            System.out.print(a);
        }
        System.out.println();
        System.out.println("wordBreak(s,set) = " + new WordBreak().wordBreak(s, set));
    }
}
