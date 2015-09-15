package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/9/16.
 */
public class PowXN {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / pow(x, -n);
        } else {
            return pow(x, n);
        }
    }

    private double pow(double x, int n) {
        if (n == 0) return 1;
        double v = pow(x, n / 2);
        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }

    public static void main(String[] args) {
        double x = 2;
        int n = 3;
        System.out.println("x = " + x + ", n = " + n);
        System.out.println("myPow(x, n) = " + new PowXN().myPow(x, n));
    }
}
