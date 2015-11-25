package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/11/25.
 */
public class IsBalancedTreeNode {
    boolean IsBalancedTreeNode(TreeNode root) {
        return (getHeight(root) != -1);
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(2);
        node1.left.left = new TreeNode(3);

        TreeNode node2 = new TreeNode(1);
        node2.left = new TreeNode(2);
        node2.right = new TreeNode(2);

        System.out.println("IsBalancedTreeNode(node1) = " + new IsBalancedTreeNode().IsBalancedTreeNode(node1));
        System.out.println("IsBalancedTreeNode(node2) = " + new IsBalancedTreeNode().IsBalancedTreeNode(node2));
    }
}
