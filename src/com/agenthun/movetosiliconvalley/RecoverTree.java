package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/12/9.
 */
public class RecoverTree {
    void recoverTree(TreeNode root, TreeNode n1, TreeNode n2, TreeNode prev) {
        if (root == null) return;
        recoverTree(root.left, n1, n2, prev);

        if (prev != null && prev.val > root.val) {
            n2 = root;
            if (n1 == null) n1 = prev;
        }
        prev = root;
        recoverTree(root.right, n1, n2, prev);
    }

    void recoverTree(TreeNode root) {
        TreeNode n1 = null, n2 = null, prev = null;
        recoverTree(root, n1, n2, prev);
        if (n1 != null && n2 != null) {
            int temp = n1.val;
            n1.val = n2.val;
            n2.val = temp;
        }
    }
}
