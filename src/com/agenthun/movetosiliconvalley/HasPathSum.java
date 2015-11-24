package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/11/24.
 */
public class HasPathSum {
    boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        } else {
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.right = new TreeNode(7);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(4);
        node.left.right.left = new TreeNode(6);
        node.left.right.right = new TreeNode(2);
        node.right.right = new TreeNode(9);

        System.out.println("hasPathSum(node,18) = " + new HasPathSum().hasPathSum(node, 18));
    }
}
