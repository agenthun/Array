package com.agenthun.schoolrecruit2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by agenthun on 16/4/2.
 */
public class ReverseSentence {
    public char toUpDown(char x) {
        if (x == ' ') return x;
        else if (x < 'a') return (char) (x + 'a' - 'A');
        else return (char) (x + 'A' - 'a');
    }

    public String trans(String s, int n) {
        // write code here
        if (s == null || s.length() == 0) return "";
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            char x = s.charAt(i);
            if (x == ' ') chars[i] = x;
            else if (x < 'a') chars[i] = (char) (x + 'a' - 'A');
            else chars[i] = (char) (x + 'A' - 'a');
        }
        String ss = new String(chars);

        String[] words = ss.split(" ");

        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        String res = new String();
        for (String x :
                words) {
            res += x + " ";
        }

        return res.trim();
    }

    private static String reverseSentence(String str) {
        if (str == null || str.length() == 0) return "";

        String[] words = str.split(" ");
        if (words.length == 0) return str;

        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        for (i = 0; i < words.length - 1; i++) {
            stringBuffer.append(words[i] + " ");
        }
        stringBuffer.append(words[i]);
        return stringBuffer.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //while (true) {
//        String s = bufferedReader.readLine();
        int n = 16;
        String s = "This is a sample";
        //System.out.println("ReverseSentence(s) = " + reverseSentence(s));
        System.out.println("trans(s,new ) = " + new ReverseSentence().trans(s, n));
//        }
    }
}
