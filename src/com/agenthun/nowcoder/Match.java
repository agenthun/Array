package com.agenthun.nowcoder;

/**
 * Created by agenthun on 16/2/29.
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Match {
    public boolean match(char[] str, char[] pattern) {
        return match(str, 0, pattern, 0);
    }

    private boolean match(char[] str, int i, char[] pattern, int j) {
        if (str.length == i && pattern.length == j) return true;
        if (j >= pattern.length) return false;

        if (j < pattern.length - 1) {
            if (pattern[j + 1] == '*') {
                if ((i < str.length) && (str[i] == pattern[j] || pattern[j] == '.')) {
                    return (match(str, i, pattern, j + 2)
                            || match(str, i + 1, pattern, j + 2)
                            || match(str, i + 1, pattern, j));
                } else {
                    return match(str, i, pattern, j + 2);
                }
            }
        }

        if (i == str.length) return false;
        if (str[i] == pattern[j] || pattern[j] == '.') return match(str, i + 1, pattern, j + 1);
        return false;
    }
}
