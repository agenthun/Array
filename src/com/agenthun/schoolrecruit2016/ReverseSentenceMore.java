package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/4/27.
 */
public class ReverseSentenceMore {
    public static String reverse(String s, int index, int end) {
        int left = index;
        int right = end;
        char[] cs = s.toCharArray();
        while (left < end) {
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

//    public static void main(String[] args) {
//        // TODO Auto -generated method stub
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        int count = Integer.parseInt(scanner.nextLine());
//        StringBuffer buffer = new StringBuffer();
//        buffer.append(s);
//
//        for (int i = 0; i < count; i++) {
//            String[] ss = scanner.nextLine().split(" ");
//            int start = Integer.parseInt(ss[0]);
//            int end = Integer.parseInt(ss[0]) +
//                    Integer.parseInt(ss[1]) - 1;
//            String sss = res(s, start, end);
//            buffer.append(sss);
//            s = buffer.toString();
//        }
//        System.out.println(buffer.toString());
//    }
//
//    public static String res(String s, int start, int end) {
//        int a = start;
//        int b = end;
//        char[] cha = s.toCharArray();
//
//        while (start < end) {
//            char temp = cha[start];
//            cha[start] = cha[end];
//            cha[end] = temp;
//            start++;
//            end--;
//        }
//
//        String ss = String.valueOf(cha);
//        String sss = ss.substring(a, b + 1);
//        return sss;
//    }
}
