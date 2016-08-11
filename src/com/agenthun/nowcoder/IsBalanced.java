package com.agenthun.nowcoder;

import java.util.ArrayList;

/**
 * Created by agenthun on 16/1/25.
 */
public class IsBalanced {
    public static boolean IsBalanced_Solution(TreeNode root) {
        return getHeight(root) != -1;
    }

    //平衡二叉树,左右子树+1,-1,0
    private static int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left); //递归左子树
        if (leftHeight == -1) return -1;
        int rightHeight = getHeight(root.right); //递归右子树
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        System.out.println("IsBalanced_Solution(node) = " + IsBalanced_Solution(node));
    }
}
