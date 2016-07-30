package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/7/30.
 * 水仙花数
 * 数{b3b2b1} = b3^3 + b2^3 + b1^3
 */
public class NarcissusNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();

            if (m > n) {
                System.out.println("no");
            } else {
                if (m >= 100 && n <= 999) {
                    int count = 0;
                    for (int i = m; i <= n; i++) {
                        int b3, b2, b1;
                        b3 = i / 100;
                        b2 = (i % 100) / 10;
                        b1 = (i % 10);
                        if (b3 * b3 * b3 + b2 * b2 * b2 + b1 * b1 * b1 == i) {
                            if (count == 0) {
                                System.out.print(i);
                            } else {
                                System.out.print(" " + i);
                            }
                            count++;
                        }
                    }
                    if (count == 0)
                        System.out.println("no");
                    else
                        System.out.println();
                } else {
                    System.out.println("no");
                }
            }
        }
    }
}
