package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/6/19.
 * 小Q最近遇到了一个难题：把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。
 * 你能帮帮小Q吗？
 * 输入描述:
 * 输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
 * 输出描述:
 * 对于每组数据，输出移位后的字符串。
 * 输入例子:
 * AkleBiCeilD
 * 输出例子:
 * kleieilABCD
 */
public class CharMove {
    private static void sort(char[] c) {
        for (int i = 1; i < c.length; i++) {
            if (c[i] > 'Z') {
                char temp = c[i];
                int j = i;
                while (j > 0 && (c[j - 1] <= 'Z')) {
                    c[j] = c[j - 1];
                    j--;
                }
                c[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            char[] c = s.toCharArray();
            sort(c);
            System.out.println(String.valueOf(c));
        }
    }
}
