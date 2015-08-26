package com.agenthun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Agent Henry on 2015/8/26.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<ArrayList<Integer>> hashSet = new HashSet<>();
        List<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list;

        if (nums == null || nums.length < 4) return lists;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    int begin = j + 1;
                    int end = nums.length - 1;
                    while (begin < end) {
                        int temp = nums[i] + nums[j] + nums[begin] + nums[end];
                        if (temp > target) {
                            end--;
                        } else if (temp < target) {
                            begin++;
                        } else {
                            list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[begin]);
                            list.add(nums[end]);
                            if (!hashSet.contains(list)) {
                                hashSet.add(list);
                                lists.add(list);
                            }
                            begin++;
                            end--;
                        }
                    }
                }
            }
        }

        return lists;
    }

    public static void main(String[] args) {
        int[] s = {-3, -2, -1, 0, 0, 1, 2, 3};
        int target = 0;
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println(", target = " + target);
        List<List<Integer>> lists = new FourSum().fourSum(s, target);
        for (int i = 0; i < lists.size(); i++) {
            System.out.print("( ");
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j) + " ");
            }
            System.out.println(")");
        }
    }
}
