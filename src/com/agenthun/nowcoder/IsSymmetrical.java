package com.agenthun.nowcoder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by agenthun on 16/2/8.
 */
public class IsSymmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;

        Queue<TreeNode> left = new LinkedList<>();
        Queue<TreeNode> right = new LinkedList<>();
        left.add(pRoot.left);
        right.add(pRoot.right);
        while (!left.isEmpty() && !right.isEmpty()) {
            TreeNode l = left.poll();
            TreeNode r = right.poll();
            if (l == null && r == null)
                continue;
            if (l == null || r == null)
                return false;
            if (l.val != r.val)
                return false;

            left.add(l.left);
            left.add(l.right);
            right.add(r.right);
            right.add(r.left);
        }
        if (left.isEmpty() && right.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(6);
        node.right = new TreeNode(6);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(7);
        node.right.left = new TreeNode(7);
        node.right.right = new TreeNode(5);

        System.out.println("new IsSymmetrical().isSymmetrical(node) = " + new IsSymmetrical().isSymmetrical(node));
    }
}
