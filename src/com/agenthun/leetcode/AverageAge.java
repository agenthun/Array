package com.agenthun.leetcode;

/**
 * Created by agenthun on 15/9/23.
 */
public class AverageAge {
    public static int getNYearsAge(double y, double x, int n) {
        double a = 1 - x;
        double b = 1 + 20 * x;
        double base = y + b / (a - 1);
        double res = Math.pow(a, n) * base;
        return (int) Math.ceil(res - b / (a - 1));
    }

    public double getPower(double a, int n) {
        double res = 1;
        for (; n != 0; n >>= 1) {
            if ((n & 1) != 0) {
                res *= a;
            }
            a *= a;
        }
        return res;
    }

    public static void main(String[] args) {
        int w = 1;
        double y = 24;
        double x = 0.9;
        int n = 1;
        System.out.println("y = " + y + ", x = " + x + ", n = " + n);
        System.out.println("getNYearsAge(y,x,n) = " + getNYearsAge(y, x, n));
    }
}
