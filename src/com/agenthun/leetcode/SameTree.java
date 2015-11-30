package com.agenthun.leetcode;

/**
 * Created by agenthun on 15/11/30.
 */
public class SameTree {
    boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null) {
            if (p.val == q.val)
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(2);
        p.left.left = new TreeNode(3);

        TreeNode q1 = new TreeNode(1);
        q1.left = new TreeNode(2);
        q1.right = new TreeNode(2);
        q1.left.left = new TreeNode(3);

        TreeNode q2 = new TreeNode(1);
        q2.left = new TreeNode(2);
        q2.right = new TreeNode(2);

        System.out.println("isSameTree(p, q1) = " + new SameTree().isSameTree(p, q1));
        System.out.println("isSameTree(p, q2) = " + new SameTree().isSameTree(p, q2));
    }
}
