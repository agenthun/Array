package com.agenthun.schoolrecruit2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by agenthun on 16/4/27.
 */
public class Main {
    public static void reverse(StringBuilder stringBuilder, int index, int len) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            stack.push(stringBuilder.charAt(index + i));
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = null;
        inputStr = bufferedReader.readLine();

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int[] index = new int[n];
        int[] len = new int[n];
        for (int i = 0; i < n; i++) {
            String[] s = bufferedReader.readLine().split(" ");
            index[i] = Integer.parseInt(s[0]);
            len[i] = Integer.parseInt(s[1]);
        }
        StringBuilder stringBuilder = new StringBuilder(inputStr);
        for (int i = 0; i < n; i++) {
            reverse(stringBuilder, index[i], len[i]);
        }
        System.out.println(stringBuilder.toString());
/*        while (bufferedReader) {
            int n = input.nextInt();
            int[] index = new int[n];
            int[] len = new int[n];
            for (int i = 0; i < n; i++) {
                index[i] = input.nextInt();
                len[i] = input.nextInt();
            }

            StringBuilder stringBuilder = new StringBuilder(inputStr);
            for (int i = 0; i < n; i++) {
                reverse(stringBuilder, index[i], len[i]);
            }

            // 输出结果
            System.out.println(stringBuilder.toString());*/
    }
}
