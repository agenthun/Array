package com.agenthun.nowcoder;

/**
 * Created by agenthun on 16/1/19.
 */
public class TreeDepth {
    public int treeDepth(TreeNode root) {
        if (root == null) return 0;
        else {
            int left = treeDepth(root.left);
            int right = treeDepth(root.right);
            return 1 + Math.max(left, right);
        }
    }
}
