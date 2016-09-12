package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/9/9.
 * 翻转两数字相加再翻转
 */
public class ReverseSum {
    private static int rev(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        int res = Integer.parseInt(sb.reverse().toString());
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            System.out.println(rev(rev(x) + rev(y)));
        }
    }
}
