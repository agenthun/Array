package com.agenthun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Agent Henry on 2015/8/23.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        if (nums.length < 3) return results;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                int mid = i + 1;
                int end = nums.length - 1;
                while (mid < end) {
                    if (nums[i] + nums[mid] + nums[end] < 0) {
                        mid++;
                    } else if (nums[i] + nums[mid] + nums[end] > 0) {
                        end--;
                    } else {
                        ArrayList<Integer> result = new ArrayList<>();
                        result.add(nums[i]);
                        result.add(nums[mid]);
                        result.add(nums[end]);
                        if (results.contains(result) == false)
                            results.add(result);
                        mid++;
                        end--;
                    }
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
        int[] s = {-1, 0, 1, 2, -1, -4};
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println();
        List<List<Integer>> arrays = new ThreeSum().threeSum(s);
        for (int i = 0; i < arrays.size(); i++) {
            System.out.print("( ");
            for (int j = 0; j < arrays.get(i).size(); j++) {
                System.out.print(arrays.get(i).get(j) + " ");
            }
            System.out.println(")");
        }
    }
}
