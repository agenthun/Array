package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/3/23.
 */
public class DeleteNumber {
    public static int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m < 0) return -1;

        int fn = 0;
        if (n != 1) {
            for (int i = 2; i <= n; i++) {
                fn = (fn + m) % i;
            }
        } else {
            fn = 1;
        }
        return fn;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int index = LastRemaining_Solution(n, 3);
            System.out.println(index);
        }
    }
}
