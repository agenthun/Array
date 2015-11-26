package com.agenthun.movetosiliconvalley;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by agenthun on 15/11/26.
 */
public class IsSymmetricTreeNode {
    boolean isSymmetricTreeNode(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> left = new LinkedList<>();
        Queue<TreeNode> right = new LinkedList<>();
        left.add(root.left);
        right.add(root.right);
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
        if (left.isEmpty() && right.isEmpty()) return true;
        else return false;
    }
}
