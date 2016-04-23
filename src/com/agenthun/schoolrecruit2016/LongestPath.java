package com.agenthun.schoolrecruit2016;

/**
 * Created by agenthun on 16/4/23.
 * 对于一棵由黑白点组成的二叉树，我们需要找到其中最长的单色简单路径，
 * 其中简单路径的定义是从树上的某点开始沿树边走不重复的点到树上的另一点结束而形成的路径，
 * 而路径的长度就是经过的点的数量(包括起点和终点)。而这里我们所说的单色路径自然就是只经过一种颜色的点的路径。
 * 你需要找到这棵树上最长的单色路径。
 * 给定一棵二叉树的根节点(树的点数小于等于300，请做到O(n)的复杂度)，请返回最长单色路径的长度。
 * 这里的节点颜色由点上的权值表示，权值为1的是黑点，为0的是白点。
 */
public class LongestPath {
    int max = 0;

    public int findPath(TreeNode root) {
        if (root == null) return 0;
        findPathdp(root);
        return max;
    }

    public int findPathdp(TreeNode root) {
        // write code here
        if (root == null) return 0;
        int leftMax = findPathdp(root.left), rightMax = findPathdp(root.right);
        int len = 1;
        if (root.left == null && root.right == null) {
            len = 1;
            max = Math.max(len, max);
        } else {
            if (root.left != null && root.left.val == root.val) {
                len += leftMax;
            }

            if (root.right != null && root.right.val == root.val) {
                len = Math.max(len, 1 + rightMax);
            }

            if (root.left == null || root.right == null) {
                max = Math.max(len, max);
            } else {
                if (root.left.val == root.right.val && root.left.val == root.val) {
                    max = Math.max(leftMax + rightMax + 1, max);
                } else {
                    max = Math.max(len, max);
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(1);
        node.right = new TreeNode(1);
        node.left.left = new TreeNode(0);
        node.left.right = new TreeNode(1);
        node.right.right = new TreeNode(1);
        int res = new LongestPath().findPath(node);
        System.out.println(res);
    }
}
