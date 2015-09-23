package com.agenthun.leetcode;

/**
 * Created by agenthun on 15/9/23.
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 1) return 0;

        int lastReach = 0;
        int reach = 0;
        int step = 0;
        for (int i = 0; i <= reach && i < nums.length; i++) {
            if (i > lastReach) {
                step++;
                lastReach = reach;
            }
            reach = Math.max(reach, nums[i] + i);
        }
        if (reach < nums.length - 1) return 0;
        return step;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 1, 4};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("jump(a) = " + new JumpGameII().jump(a));
    }
}
