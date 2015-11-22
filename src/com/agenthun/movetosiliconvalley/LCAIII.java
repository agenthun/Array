package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/11/22.
 */
public class LCAIII {
    TreeNode LCAIII(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = LCAIII(root.left, p, q);
        TreeNode right = LCAIII(root.right, p, q);

        if (left != null && right != null) return root;
        return left == null ? right : left;
    }
}
