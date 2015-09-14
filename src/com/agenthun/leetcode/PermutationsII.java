package com.agenthun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Henry on 2015/9/14.
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, new ArrayList<Integer>(), result, used);
        return result;
    }

    private void helper(int[] nums, List<Integer> sub, List<List<Integer>> result, boolean[] used) {
        if (sub.size() == nums.length) {
            ArrayList<Integer> clone = new ArrayList<>(sub);
            result.add(clone);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && !used[i - 1] && nums[i] == nums[i - 1])) continue;
            sub.add(nums[i]);
            used[i] = true;
            helper(nums, sub, result, used);
            sub.remove(sub.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 3};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("result :");
        List<List<Integer>> result = new PermutationsII().permuteUnique(a);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
