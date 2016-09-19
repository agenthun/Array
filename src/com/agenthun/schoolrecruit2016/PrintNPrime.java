package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/9/19.
 * 输出第N个素数
 * 1 2 3 4 5 6 7 8
 * 2 3 5 7 11 13 17 19
 */
public class PrintNPrime {
    public static int getPrime(int n) {
        int res = 2;
        int counter = 0;
        int number = Integer.MAX_VALUE;
        for (int i = 2; i < number; i++) {
            boolean isOk = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                counter++;
                if (counter == n) {
                    res = i;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int res = getPrime(n);
            System.out.println(res);
        }
    }
}
