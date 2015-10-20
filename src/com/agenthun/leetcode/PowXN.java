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

    public double myPowAdv(double x, int n) {
        if (n < 0) {
            return 1 / powAdv(x, -n);
        } else {
            return powAdv(x, n);
        }
    }

    private double powAdv(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if ((n & 0x01) == 0) {
            return powAdv(x * x, n / 2);
        } else {
            return powAdv(x * x, n / 2) * x;
        }
    }

    public static void main(String[] args) {
        double x = 100;
        int n = 100;
        System.out.println("x = " + x + ", n = " + n);
        long beginTime = System.currentTimeMillis();
        System.out.println("myPow(x, n) = " + new PowXN().myPow(x, n));
        long endTime = System.currentTimeMillis();
        System.out.println("time = " + (endTime - beginTime));

        beginTime = System.currentTimeMillis();
        System.out.println("myPowAdv(x, n) = " + new PowXN().myPowAdv(x, n));
        endTime = System.currentTimeMillis();
        System.out.println("time = " + (endTime - beginTime));
    }
}
