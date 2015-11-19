package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/11/20.
 */
public class LCA {
    TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        if (root.val > p.val && root.val > q.val) {
            return LCA(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return LCA(root.right, p, q);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.right = new TreeNode(9);

        TreeNode node = new LCA().LCA(treeNode, new TreeNode(3), new TreeNode(4));
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}