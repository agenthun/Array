package com.agenthun.schoolrecruit2016;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by agenthun on 16/4/27.
 */
public class ReverseSentenceMore {
    public static String reverse(String s, int index, int end) {
        int left = index;
        int right = end;
        while (left)
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();

        int n = Integer.parseInt(scanner.nextLine());
        int[] index = new int[n];
        int[] end = new int[n];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(inputStr);
        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split(" ");
            index[i] = Integer.parseInt(s[0]);
            end[i] = Integer.parseInt(s[0]) + Integer.parseInt(s[1]) - 1;
            String ss = reverse(inputStr, index[i], end[i]);
            stringBuilder.append(ss);
            inputStr = stringBuilder.toString();

        }
        System.out.println(stringBuilder.toString());
/*        while (bufferedReader) {
            int n = input.nextInt();
            int[] index = new int[n];
            int[] end = new int[n];
            for (int i = 0; i < n; i++) {
                index[i] = input.nextInt();
                end[i] = input.nextInt();
            }

            StringBuilder stringBuilder = new StringBuilder(inputStr);
            for (int i = 0; i < n; i++) {
                reverse(stringBuilder, index[i], end[i]);
            }

            // 输出结果
            System.out.println(stringBuilder.toString());*/
    }
}
