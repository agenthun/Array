package com.agenthun.movetosiliconvalley;

import java.util.ArrayList;

/**
 * Created by agenthun on 15/12/11.
 */
public class MaxPathSumTree {
    int maxPathSumTree(TreeNode root) {
        ArrayList<Integer> maxSum = new ArrayList<>();
        maxSum.add(Integer.MIN_VALUE);
        getMaxSum(root, maxSum);
        return maxSum.get(0);
    }

    private int getMaxSum(TreeNode root, ArrayList<Integer> maxSum) {
        if (root == null) return 0;
        int leftSum = 0, rightSum = 0;
        leftSum = getMaxSum(root.left, maxSum);
        rightSum = getMaxSum(root.right, maxSum);
        int curSum = Math.max(root.val, Math.max(root.val + leftSum, root.val + rightSum));
        maxSum.set(0, Math.max(maxSum.get(0), Math.max(curSum, root.val + leftSum + rightSum)));
        return curSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println("maxPathSumTree(root) = " + new MaxPathSumTree().maxPathSumTree(root));
    }
}
