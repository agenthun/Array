package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/12/1.
 */
public class InorderSuccTree {
    TreeNode inorderSuccTree(TreeNode e) {
        if (e == null) return null;
        if (e.right != null) {
            return getLeftMost(e.right);
        } else {
            TreeNode p = e.parent;
            while (p != null && p.left != e) {
                e = p;
                p = e.parent;
            }
            return p;
        }
    }

    private TreeNode getLeftMost(TreeNode e) {
        TreeNode res = e;
        while (res.left != null) res = res.left;
        return res;
    }
}
