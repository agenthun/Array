package com.agenthun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Agent Henry on 2015/9/11.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);

        combinationSum(candidates, target, 0, current, result);
        return result;
    }

    private void combinationSum(int[] candidates, int target, int j, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            ArrayList<Integer> temp = new ArrayList<>(current);
            result.add(temp);
            return;
        }

        for (int i = j; i < candidates.length; i++) {
            if (target < candidates[i]) return;
            current.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7};
        int target = 7;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("target = " + target);
        List<List<Integer>> list = new CombinationSum().combinationSum(a, target);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
