package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/12/3.
 */
public class FindClosestBST {
    TreeNode findClosestBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode left = findClosestBST(root.left, val);
        TreeNode right = findClosestBST(root.right, val);
        int diffLeft = left == null ? Integer.MAX_VALUE : Math.abs(val - left.val);
        int diffRight = right == null ? Integer.MAX_VALUE : Math.abs(val - right.val);

        int diff = Math.abs(val - root.val);
        int min = Math.min(diff, Math.min(diffLeft, diffRight));
        if (min == diff) return root;
        else if (min == diffLeft) return left;
        else return right;
    }
}
