package com.agenthun.leetcode;

import java.util.Arrays;

/**
 * Created by Agent Henry on 2015/8/24.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return Integer.MIN_VALUE;
        if (nums.length == 3) return nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int mid = i + 1;
            int end = nums.length - 1;
            while (mid < end) {
                int temp = nums[i] + nums[mid] + nums[end];
                if (temp < target) {
                    mid++;
                } else if (temp > target) {
                    end--;
                } else {
/*                    mid++;
                    end--;
                    res = temp;*/
                    return temp;
                }
                if (Math.abs(temp - target) < Math.abs(res - target)) res = temp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] s = {-1, 2, 1, -4};
        int[] s = {-3, -2, -5, 3, -4};
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println();
        System.out.println("threeSumClosest(s, -1) = " + new ThreeSumClosest().threeSumClosest(s, -1));
    }
}
