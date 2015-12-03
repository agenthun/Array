package com.agenthun.movetosiliconvalley;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by agenthun on 15/12/4.
 */
public class BSTIterator implements Iterator<Integer> {
    private Stack<TreeNode> stack = new Stack<>();

    BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    private void pushLeft(TreeNode x) {
        while (x != null) {
            stack.push(x);
            x = x.left;
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Integer next() {
        TreeNode x = stack.pop();
        pushLeft(x.right);
        return x.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(9);
        BSTIterator iterator = new BSTIterator(root.left);
        System.out.println(iterator.next() + "");
    }
}
