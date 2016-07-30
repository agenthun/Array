package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/7/30.
 * 求数列和
 */
public class ArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double n = scanner.nextInt();
            double m = scanner.nextInt();

            if (n < 10000 && m < 1000) {
                double sum = 0;
                for (int i = 0; i < m; i++) {
                    sum += n;
                    n = Math.sqrt(n);
                }
                System.out.printf("%.2f", sum);
                System.out.println();
            }
        }
    }
}
