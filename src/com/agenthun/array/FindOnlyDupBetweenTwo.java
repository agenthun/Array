package com.agenthun.array;

/**
 * Created by Agent Henry on 2015/8/9.
 */
public class FindOnlyDupBetweenTwo {

    public static int findOnlyDupBetweenTwo(int[] a, int[] b) {
        int result = 0;
        int i;
        for (i = 0; i < Math.min(a.length, b.length); i++) {
            result ^= a[i] ^ b[i];
        }
        if (a.length > b.length) result ^= a[i];
        else result ^= b[i];
        return result;
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 3, 2, 6, 9, 3, 9};
        int[] b = {3, 2, 6, 9, 3, 2, 2, 9, 4};
        System.out.println("the different one between a and b is " + findOnlyDupBetweenTwo(a, b));
    }
}
