package com.agenthun.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Agent Henry on 2015/8/31.
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            if (nums[i] == nums[j]) {
                i++;
            } else {
                j++;
                nums[j] = nums[i];
                i++;
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("removeDuplicates(a) = " + new RemoveDuplicatesFromSortedArray().removeDuplicates(a));
    }
}
