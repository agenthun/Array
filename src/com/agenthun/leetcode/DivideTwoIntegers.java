package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/9/4.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (divisor == -1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        long pDividend = Math.abs((long) dividend);
        long pDivisor = Math.abs((long) divisor);

        int result = 0;
        while (pDividend >= pDivisor) {
            int numShift = 0;
            while (pDividend >= (pDivisor << numShift)) {
                numShift++;
            }

            result += 1 << (numShift - 1);
            pDividend -= (pDivisor << (numShift - 1));
        }

        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            return result;
        } else {
            return -result;
        }
    }

    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = -1;
        System.out.println("dividend = " + dividend + ", divisor = " + divisor);
        System.out.println("divide(dividend, divisor) = " + new DivideTwoIntegers().divide(dividend, divisor));
    }
}
