package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/9/17.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }

    //两个max,sum
    //max为到当前最大
    //sum为累加到当前和,若和为负数则清零
    public int maxSubArrayMine(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (sum < 0) sum = 0;
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("maxSubArray(a) = " + new MaximumSubarray().maxSubArray(a));
        System.out.println("maxSubArrayMine(a) = " + new MaximumSubarray().maxSubArrayMine(a));
    }
}
