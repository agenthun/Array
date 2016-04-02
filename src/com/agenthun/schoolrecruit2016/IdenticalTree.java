package com.agenthun.schoolrecruit2016;

/**
 * Created by agenthun on 16/4/2.
 * 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
 * 给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。
 */
public class IdenticalTree {
    public boolean chkIdentical(TreeNode A, TreeNode B) {
        // write code here
        if (B == null) return true;
        else if (A == null) return false;

        boolean result = false;
        if (A != null && B != null) {
            if (A.val == B.val) {
                result = doesTree1HaveTree2(A, B);
            }
            if (!result)
                return chkIdentical(A.left, B) || chkIdentical(A.right, B);
        }
        return result;
    }

    private boolean doesTree1HaveTree2(TreeNode a, TreeNode b) {
        if (b == null) return false;
        else if (a == null) return false;

        if (a.val != b.val) {
            return false;
        } else {
            return doesTree1HaveTree2(a.left, b.left) &&
                    doesTree1HaveTree2(a.right, b.right);
        }
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
