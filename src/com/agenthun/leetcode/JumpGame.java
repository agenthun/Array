package com.agenthun.leetcode;

/**
 * Created by agenthun on 15/9/22.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (max <= i && nums[i] == 0) return false;
            if (nums[i] + i > max) {
                max = nums[i] + i;
            }
            if (max > nums.length - 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 1, 4};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("canJump(a) = " + new JumpGame().canJump(a));
    }
}
