package com.agenthun.leetcode;

import java.util.Arrays;

/**
 * Created by agenthun on 15/12/14.
 */
public class MajorityElement {
    int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        int[] a = {4, 1, 2, 2, 3, 4, 4, 4, 4};
        for (int temp :
                a) {
            System.out.print(temp + " ");
        }
        System.out.println();
        System.out.println("majorityElement(a) = " + new MajorityElement().majorityElement(a));
    }
}
