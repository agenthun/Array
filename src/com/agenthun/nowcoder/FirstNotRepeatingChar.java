package com.agenthun.nowcoder;

/**
 * Created by agenthun on 16/2/22.
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符的位置。
 * 若为空串，返回-1。位置索引从0开始
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) return -1;
        char c = 'A';
        if (str.charAt(0) >= 'a') {
            c = 'a';
        }

        int[] counts = new int[26];
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i) - c]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (counts[str.charAt(i) - c] == 1) {
                return i;
            }
        }
        return -1;
    }
}
