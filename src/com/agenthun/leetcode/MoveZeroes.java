package com.agenthun.leetcode;

/**
 * Created by agenthun on 15/12/19.
 */
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos] = nums[i];
                pos++;
            }
        }
        for (; pos < nums.length; pos++) {
            nums[pos] = 0;
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 12};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("result:");

        moveZeroes(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
