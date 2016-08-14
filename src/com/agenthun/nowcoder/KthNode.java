package com.agenthun.nowcoder;

import java.util.Stack;

/**
 * Created by huheng on 3/3/2016.
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。
 * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 * <p>
 * 中序遍历：递归节点的左子数
 */
public class KthNode {
    //KthNode 二叉搜索树的第k个结点
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) return null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode result = null;
        int index = 0;

        pushLeft(stack, pRoot); //将左节点push到栈中
        while (!stack.isEmpty()) { //取最左节点
            TreeNode node = stack.pop();
//            System.out.print(node.val + " ");
            if (++index >= k) { //判断是否是第K个
                result = node;
                break;
            }
            if (node.right != null) { //有右节点，将右节点开始的左节点push
                pushLeft(stack, node.right);
            }
        }
        return result;
    }

    private void pushLeft(Stack<TreeNode> stack, TreeNode root) {
        if (root == null) return;
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        int k = 3;
        TreeNode kNode = new KthNode().KthNode(root, k);
        System.out.println("kNode = " + kNode.val);
    }

}