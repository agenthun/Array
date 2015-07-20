package com.agenthun.array;

/**
 * Created by Agent Henry on 2015/7/20.
 */
public class FindMaxRecursion {
    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int maxnux(int[] a, int begin) {
        int len = a.length - begin;
        if (len == 1) return a[begin];
        else return max(a[begin], maxnux(a, begin + 1));
    }

    public static void main(String[] args) {
        int[] a = {0, 16, 2, 3, 4, 5, 10, 7, 8, 9};
        System.out.println("max = " + maxnux(a, 0));
    }
}
