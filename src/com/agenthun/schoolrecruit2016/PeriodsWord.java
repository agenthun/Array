package com.agenthun.schoolrecruit2016;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daydreamer on 2016/7/10.
 * 对于两个字符串B和C，我们定义BC为将C接在B的后面形成的新串。
 * 一个字符串P是串A的前缀，当且仅当存在B使得A＝PB，当然B可以为空串。若P!=A,则我们称P为A的真前缀。
 * 现在定义重复词。串Q是串A的重复词当且仅当Q是A的真前缀，且A是QQ的前缀。
 * 而A的最长重复词则是A的重复词中最长的一个，或者空串（当A没有任何重复串时）。
 * 如ababab的最长重复词是abab;abc的最长重复词是空串。
 * 给定一个串s(由字母组成)，及它的长度n(1≤n≤100000)，
 * 请返回s的所有前缀的最长重复词的长度之和(空串长度为0)。
 * 测试样例：
 * 8,"babababa"
 * 返回：24
 */
public class PeriodsWord {
    public long getLongest(int n, String s) {
        // write code here
        if (n == 1) return 0;

        char[] chars = s.toCharArray();
        List<Integer> list = new ArrayList<>();

        for (int i = n - 1; i > 0; i--) {
            if (chars[i] == chars[0]) {
                list.add(i);
            }
        }

        long sum = 0;
        int[] a = new int[n];
        for (int i = 0; i < list.size(); i++) {
            for (int j = list.get(i), k = 0; j < n; j++, k++) {
                if (chars[k] == chars[j]) {
                    a[j] = (a[j] > list.get(i)) ? a[j] : list.get(i);
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 8;
        String s = "babababa";
        System.out.println(new PeriodsWord().getLongest(n, s));
    }
}
