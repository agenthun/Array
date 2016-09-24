package com.agenthun.array;

import java.util.Scanner;

/**
 * Created by Agent Henry on 2015/7/17.
 */
public class ShiftK {
    public static void reverse(int[] a, int b, int e) {
        for (; b < e; b++, e--) {
            int temp = a[e];
            a[e] = a[b];
            a[b] = temp;
        }
    }

    public static void shiftK(int[] a, int k) {
        int len = a.length;
        k = k % len; //防止k比a长度大
        reverse(a, 0, len - k - 1);
        reverse(a, len - k, len - 1);
        reverse(a, 0, len - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = scanner.nextInt();
            }

            int k = scanner.nextInt();
            shiftK(a, k);
        }
    }
}
