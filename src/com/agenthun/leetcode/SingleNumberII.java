package com.agenthun.leetcode;

/**
 * Created by agenthun on 15/12/25.
 */
public class SingleNumberII {
    int singleNumber(int[] nums) {
        int one = 0, two = 0, three = 0;
        for (int i = 0; i < nums.length; i++) {
            two |= one & nums[i];
            one ^= nums[i];
            three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }

    public static void main(String[] args) {
        int[] a = {5, 1, 2, 3, 4, 3, 5, 1, 2, 1, 2, 3, 5};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("singleNumber(a) = " + new SingleNumberII().singleNumber(a));
    }
}
