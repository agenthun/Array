package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/4/27.
 */
public class ReverseSentenceMore {
    public static String reverse(String s, int index, int len) {
        int left = index;
        int right = len + index - 1;
        char[] cs = s.toCharArray();
        while (left < right) {
            char temp = cs[left];
            cs[left] = cs[right];
            cs[right] = temp;
            left++;
            right--;
        }
        return cs.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();

        int n = Integer.parseInt(scanner.nextLine());
        int[] index = new int[n];
        int[] len = new int[n];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(inputStr);
        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split(" ");
            index[i] = Integer.parseInt(s[0]);
            len[i] = Integer.parseInt(s[1]);

            String subStr = inputStr.substring(index[i], len[i]);
            String reverseSubStr = reverse(subStr, 0, subStr.length());
        }
        System.out.println(stringBuilder.toString());
    }
}
