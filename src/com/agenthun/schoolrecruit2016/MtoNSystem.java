package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/9/9.
 */
public class MtoNSystem {
    private static String D2N(long m, int n) {
        StringBuilder sb = new StringBuilder();
        while (m != 0) {
            int temp = (int) (m % n);
            if (temp > 9 && n > 9) {
                sb.append((char) ('A' + temp - 10));
            } else {
                sb.append(temp);
            }
            m = m / n;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long m = scanner.nextLong();
            int n = scanner.nextInt();
            System.out.println(D2N(m, n));
        }
    }
}
