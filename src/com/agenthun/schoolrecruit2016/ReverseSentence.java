package com.agenthun.schoolrecruit2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by agenthun on 16/4/2.
 */
public class ReverseSentence {
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

        int i;
        StringBuffer stringBuffer = new StringBuffer();
        for (i = 0; i < words.length - 1; i++) {
            stringBuffer.append(words[i] + " ");
        }
        stringBuffer.append(words[i]);
        return stringBuffer.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = bufferedReader.readLine();
            System.out.println("ReverseSentence(s) = " + reverseSentence(s));
        }
    }
}
