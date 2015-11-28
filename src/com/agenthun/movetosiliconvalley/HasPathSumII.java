package com.agenthun.movetosiliconvalley;

import java.util.ArrayList;

/**
 * Created by agenthun on 15/11/28.
 */
public class HasPathSumII {
    void findPathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        findPathSumHelper(root, sum, path, res, 0);
    }

    private void findPathSumHelper(TreeNode root, int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res, int level) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null & root.right == null) {
            int tmp = root.val;
            for (int i = level; i > -1; i--) {
                tmp -= path.get(i);
                if (tmp == 0) copyList(path, i, level, res);
            }
        } else {
            findPathSumHelper(root.left, sum, path, res, level + 1);
            findPathSumHelper(root.right, sum, path, res, level + 1);
        }
        path.remove(path.size() - 1);
    }

    private void copyList(ArrayList<Integer> path, int from, int end, ArrayList<ArrayList<Integer>> res) {
        ArrayList<Integer> subPath = new ArrayList<>();
        for (int i = from; i <= end; i++) {
            subPath.add(path.get(i));
        }
        res.add(subPath);
    }
}
