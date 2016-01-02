package com.agenthun.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by agenthun on 16/1/2.
 */
public class ReverseWordsInAString {
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        String[] a = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = a.length - 1; i >= 0; i--) {
            if (!a[i].equals("")) {
                sb.append(a[i]).append(" ");
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("str = ");
        String str = reader.readLine();
        System.out.println("reverseWords(str) = " + reverseWords(str));
    }
}
