package com.agenthun.leetcode;

/**
 * Created by agenthun on 15/12/12.
 */
public class SingleNumber {
    int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 1, 2, 3, 5};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("singleNumber(a) = " + new SingleNumber().singleNumber(a));
    }
}
