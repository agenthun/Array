package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/9/9.
 * 求阶乘和
 * 1!+2!+3!+...+n!
 */
public class FactorialSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();

            int sum = 0;
            int temp = 1;
            for (int i = 1; i <= n; i++) {
                temp = temp * i;
                sum += temp;
            }
            System.out.println(sum);
        }
    }
}
