package com.agenthun.nowcoder;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by agenthun on 16/2/4.
 */
public class FindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> pathAll = new ArrayList<>();
        if (root == null) return pathAll;

        Stack<Integer> stack = new Stack<>();
        findPathHelper(root, target, pathAll, stack, 0);
        return pathAll;
    }

    private void findPathHelper(TreeNode root, int target, ArrayList<ArrayList<Integer>> lists, Stack<Integer> stack, int sum) {
        if (root == null) {
            return;
        }
        // 把当前结点进栈
        stack.push(root.val);
        sum += root.val;
        // 如果是叶子结点，而且和为给定的值，则打印路径
        if ((root.left == null && root.right == null) && sum == target) {
            ArrayList<Integer> list = new ArrayList<>();
            list.addAll(stack);
            lists.add(list);
        }

        // 如果不是叶子结点，则遍历它的子结点
        if (root.left != null) {
            findPathHelper(root.left, target, lists, stack, sum);
        }
        if (root.right != null) {
            findPathHelper(root.right, target, lists, stack, sum);
        }
        // 在返回到父结点之前，在路径上删除当前结点
        stack.pop();
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(12);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(7);

        ArrayList<ArrayList<Integer>> lists = new FindPath().FindPath(node, 22);
        for (ArrayList<Integer> list :
                lists) {
            for (Integer x :
                    list) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
