package com.agenthun.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Agent Henry on 2015/9/5.
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return null;

        int len = words[0].length();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String w : words) {
            if (hashMap.containsKey(w)) {
                hashMap.put(w, hashMap.get(w) + 1);
            } else {
                hashMap.put(w, 1);
            }
        }

        for (int j = 0; j < len; j++) {
            HashMap<String, Integer> curHashMap = new HashMap<>();
            int start = j;
            int count = 0;

            for (int i = j; i <= s.length() - len; i = i + len) {
                String sub = s.substring(i, i + len);
                if (hashMap.containsKey(sub)) {
                    if (curHashMap.containsKey(sub)) {
                        curHashMap.put(sub, curHashMap.get(sub) + 1);
                    } else {
                        curHashMap.put(sub, 1);
                    }
                    count++;

                    while (curHashMap.get(sub) > hashMap.get(sub)) {
                        String left = s.substring(start, start + len);
                        curHashMap.put(left, curHashMap.get(left) - 1);
                        count--;
                        start = start + len;
                    }

                    if (count == words.length) {
                        result.add(start);
                        String left = s.substring(start, start + len);
                        curHashMap.put(left, curHashMap.get(left) - 1);
                        count--;
                        start = start + len;
                    }
                } else {
                    curHashMap.clear();
                    start = i + len;
                    count = 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(s);
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i] + " ");
        }
        System.out.println();
        List<Integer> list = new SubstringWithConcatenationOfAllWords().findSubstring(s, words);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
