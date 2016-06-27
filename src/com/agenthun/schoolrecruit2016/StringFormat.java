package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/6/27.
 * 请你实现一个简单的字符串替换函数。原串中需要替换的占位符为"%s",请按照参数列表的顺序一一替换占位符。
 * 若参数列表的字符数大于占位符个数。则将剩下的参数字符添加到字符串的结尾。
 * 给定一个字符串A，同时给定它的长度n及参数字符数组arg和它的大小m，请返回替换后的字符串。
 * 保证参数个数大于等于占位符个数。保证原串由大小写英文字母组成，同时长度小于等于500。
 * 测试样例：
 * "A%sC%sE",7,['B','D','F']
 * 返回：
 * "ABCDEF"
 */
public class StringFormat {
    public static String formatString(String A, int n, char[] arg, int m) {
        // write code here
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) != '%') {
                sb.append(A.charAt(i));
            } else {
                if (index <= (m - 1)) {
                    sb.append(arg[index]);
                    index++;
                }
                i++;
            }
        }

        while (index <= (m - 1)) {
            sb.append(arg[index]);
            index++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            char[] arg = new char[m];
            for (int i = 0; i < arg.length; i++) {
                arg[i] = scanner.next().charAt(0);
            }

            String res = formatString(str, n, arg, m);
            System.out.println(res);
        }
    }
}
