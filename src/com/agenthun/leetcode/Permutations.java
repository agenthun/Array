package com.agenthun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Agent Henry on 2015/9/14.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums, int[][] map) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        int[] dist = new int[2];
        dist[0] = Integer.MAX_VALUE;
        dist[1] = Integer.MAX_VALUE;
        helper(nums, new ArrayList<Integer>(), result, used, map, dist);
        System.out.println("dist min" + dist[0]);
        return result;
    }

    private void helper(int[] nums, List<Integer> sub, List<List<Integer>> result, boolean[] used, int[][] map, int[] dist) {
        if (sub.size() == nums.length) {
            ArrayList<Integer> clone = new ArrayList<>(sub);
            int temp = 0;
            for (int i = 0; i < sub.size() - 1; i++) {
                temp += map[sub.get(i) - 1][sub.get(i + 1) - 1];
            }
            if (temp < dist[0]) dist[0] = temp;
            System.out.println("dist=" + dist[0]);
            result.add(clone);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            sub.add(nums[i]);
            used[i] = true;
            helper(nums, sub, result, used, map, dist);
            sub.remove(sub.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[][] map = {
                {0, 1, 2, 3},
                {1, 0, 4, 5},
                {2, 4, 0, 2},
                {3, 5, 2, 0}
        };
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("result :");
        List<List<Integer>> result = new Permutations().permute(a, map);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
