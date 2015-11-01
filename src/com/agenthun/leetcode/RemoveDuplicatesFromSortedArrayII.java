package com.agenthun.leetcode;

/**
 * Created by agenthun on 15/11/1.
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int pre = 1;
        int cur = 2;
        while (cur < nums.length) {
            if (nums[cur] == nums[pre] && nums[cur] == nums[pre - 1]) {
                cur++;
            } else {
                pre++;
                nums[pre] = nums[cur];
                cur++;
            }
        }
        return pre + 1;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 2, 3};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("removeDuplicates(a) = " + new RemoveDuplicatesFromSortedArrayII().removeDuplicates(a));
    }
}
