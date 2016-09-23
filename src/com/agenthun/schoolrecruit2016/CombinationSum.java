package com.agenthun.schoolrecruit2016;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by agenthun on 16/9/9.
 * 5 15
 * 5 5 10 2 3
 * 输出4
 */
public class CombinationSum {
    public static int combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return 0;
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);

        combinationSum2(candidates, target, 0, current, result);
        int[] count = new int[2];
        combinationSum2(candidates, target, 0, current, count);
        return result.size();
    }

    private static void combinationSum2(int[] candidates, int target, int j, List<Integer> current, List<List<Integer>> result) {
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

    private static void combinationSum2(int[] candidates, int target, int j, List<Integer> current, int[] count) {
        if (target == 0) {
            count[0]++;
            return;
        }

        for (int i = j; i < candidates.length; i++) {
            if (target < candidates[i]) return;
            current.add(candidates[i]);
            combinationSum2(candidates, target - candidates[i], i + 1, current, count);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int sum = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            int res = combinationSum2(a, sum);
            System.out.println(res);
        }
    }
}
