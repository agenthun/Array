package com.agenthun.leetcode;

/**
 * Created by agenthun on 15/9/25.
 */
public class Sqrtx {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int end = x >> 1;
        int begin = 1;
        while (begin <= end) {
            int mid = (begin + end) >> 1;
            int temp = x / mid;
            if (temp == mid) return mid;
            else if (temp < mid) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return (begin + end) >> 1;
    }

    public static void main(String[] args) {
        int x = 1;
        System.out.println("x = " + x);
        System.out.println("mySqrt(x) = " + new Sqrtx().mySqrt(x));
    }
}
