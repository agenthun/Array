package com.agenthun.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agent Henry on 2015/9/16.
 */
public class NQueens {
/*    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        int[] loc = new int[n];
        dfs(results, loc, 0, n);
        return results;
    }

    private void dfs(List<List<String>> results, int[] loc, int cur, int n) {
        if (cur == n) printboard(results, loc, n);
        else {
            for (int i = 0; i < n; i++) {
                loc[cur] = i;
                if (isValid(loc, cur)) dfs(results, loc, cur + 1, n);
            }
        }
    }

    private void printboard(List<List<String>> results, int[] loc, int n) {
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            String row = new String();
            for (int j = 0; j < n; j++) {
                if (j == loc[i]) row += "Q";
                else row += ".";
            }
            ans[i] = row;
        }
        results.add(ans);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("n = " + n);
        List<List<String>> results = new NQueens().solveNQueens(n);
        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < results.get(i).size(); j++) {
                System.out.println(results.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }*/
}
