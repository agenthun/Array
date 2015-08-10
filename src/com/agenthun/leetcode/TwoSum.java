package com.agenthun.leetcode;

import java.util.HashMap;

/**
 * Created by Agent Henry on 2015/8/10.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> n = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer temp = n.get(nums[i]);
            if (temp == null) n.put(nums[i], i);
            temp = n.get(target - nums[i]);
            if (temp != null && temp < i) {
                result[0] = temp + 1;
                result[1] = i + 1;
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] numbers = {0, 4, 3, 0};
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(numbers, target);
        System.out.println("index1=" + result[0] + ", index2=" + result[1]);
    }
}
