package com.agenthun.array;

/**
 * Created by Agent Henry on 2015/7/14.
 */
public class SecondMax {
    public static int FindSecondMax(int[] a) {
        int len = a.length;
        int max = a[0];
        int secMax = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            if (a[i] > max) {
                secMax = max;
                max = a[i];
            } else {
                if (a[i] > secMax)
                    secMax = a[i];
            }
        }
        return secMax;
    }

    public static void main(String[] args) {
        int[] a = {7, 3, 19, 40, 4, 7, 1};
        System.out.println("secMax = " + FindSecondMax(a));
    }
}
