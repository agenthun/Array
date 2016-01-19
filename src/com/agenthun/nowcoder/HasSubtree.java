package com.agenthun.nowcoder;

/**
 * Created by agenthun on 16/1/19.
 */
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        else if (root1 == null) return false;
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val)
                result = doesTree1HaveTree2(root1, root2);
            if (!result)
                return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
        return result;
    }

    private boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        else if (root1 == null) return false;

        if (root1.val != root2.val)
            return false;
        else
            return doesTree1HaveTree2(root1.left, root2.left) &&
                    doesTree1HaveTree2(root1.right, root2.right);
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
