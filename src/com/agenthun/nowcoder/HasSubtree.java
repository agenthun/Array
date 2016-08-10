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
            if (root1.val == root2.val) //值相同,开始递归遍历
                result = doesTree1HaveTree2(root1, root2);
            if (!result) //不相同,找左右子树里的
                return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
        return result;
    }

    private boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) return false;
        else if (root1 == null) return false; //为null即舍弃

        if (root1.val != root2.val) //值不同也舍弃
            return false;
        else //遍历相同值的左右子树
            return doesTree1HaveTree2(root1.left, root2.left) &&
                    doesTree1HaveTree2(root1.right, root2.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(2);
        node1.left.left = new TreeNode(3);
        node1.left.right = new TreeNode(4);

        // TreeNode node2 = new TreeNode(2);
        // node2.left = new TreeNode(3);
        // node2.right = new TreeNode(4);
        TreeNode node2 = null;

        System.out.println("HasSubtree(node1,node2) = " + new HasSubtree().HasSubtree(node1, node2));
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
