package com.agenthun.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by agenthun on 15/11/19.
 */
public class BinaryTreePaths {
    List<String> result = new LinkedList<>();
    List<Integer> path = new LinkedList<>();

    List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return result;
        getPaths(root);
        return result;
    }

    private void getPaths(TreeNode node) {
        if (node == null) return;
        path.add(node.val);
        if (node.left == null && node.right == null) {
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < path.size(); i++) {
                if (i != 0) buffer.append("->");
                buffer.append(path.get(i));
            }
            result.add(buffer.toString());
        }
        getPaths(node.left);
        getPaths(node.right);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(5);

        List<String> result = new BinaryTreePaths().binaryTreePaths(treeNode);
        for (String node :
                result) {
            System.out.println(node);
        }
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
