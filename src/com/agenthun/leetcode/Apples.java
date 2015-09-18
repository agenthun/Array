package com.agenthun.leetcode;

import java.util.Scanner;

/**
 * Created by Agent Henry on 2015/9/18.
 */
public class Apples {
    public long appleCount(int n) {
        long before = (long) (Math.pow(n, n) - (n - 1));
        return before;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if (N <= 1 || N >= 9) return;
        System.out.println("N = " + N);
        long count = new Apples().appleCount(N);
        System.out.println("count = " + count);
    }
}
