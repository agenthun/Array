package com.agenthun.schoolrecruit2016;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by agenthun on 16/4/7.
 * 对于一个字符串，请设计一个高效算法，找到第一次重复出现的字符。
 * 给定一个字符串(不一定全为字母)A及它的长度n。请返回第一个重复出现的字符。保证字符串中有重复字符，字符串的长度小于等于500。
 * 测试样例：
 * "qywyer23tdd",11
 * 返回：y
 */
public class FindFirstRepeat {
    public char findFirstRepeat(String A, int n) {
        // write code here
        char res = '0';
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            if (map.containsKey(ch)) {
                res = ch;
                break;
            } else {
                map.put(ch, 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String A = "qywyer23tdd";
        int n = 11;
        System.out.println("A = " + A);
        System.out.println("n = " + n);
        char res = new FindFirstRepeat().findFirstRepeat(A, n);
        System.out.println("res = " + res);
    }
}
