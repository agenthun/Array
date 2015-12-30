package com.agenthun.leetcode;

import java.util.Arrays;

/**
 * Created by agenthun on 15/12/29.
 */
public class MissingNumber {
    int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        Arrays.sort(nums);
        int i;
        for (i = 0; i < nums.length; i++) {
            if (i != nums[i]) return i;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] n = {0, 1, 3};
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + " ");
        }
        System.out.println();
        System.out.println("missingNumber(n) = " + new MissingNumber().missingNumber(n));
    }
}
