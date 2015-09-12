package com.agenthun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Agent Henry on 2015/9/12.
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);

        combinationSum2(candidates, target, 0, current, result);

        //不同于combinationSum
        HashSet<List<Integer>> set = new HashSet<>(result);
        result.clear();
        result.addAll(set);

        return result;
    }

    private void combinationSum2(int[] candidates, int target, int j, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            ArrayList<Integer> temp = new ArrayList<>(current);
            result.add(temp);
            return;
        }

        for (int i = j; i < candidates.length; i++) {
            if (target < candidates[i]) return;
            current.add(candidates[i]);
            combinationSum2(candidates, target - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("target = " + target);
        List<List<Integer>> list = new CombinationSumII().combinationSum2(a, target);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
