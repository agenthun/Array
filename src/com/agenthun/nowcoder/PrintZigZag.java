package com.agenthun.nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by agenthun on 16/2/27.
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintZigZag {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;

        ArrayList<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int current = 1;
        int next = 0;
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            current--;
            list.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
                next++;
            }
            if (node.right != null) {
                queue.add(node.right);
                next++;
            }

            if (current == 0) {
                if (leftToRight) {
                    result.add(list);
                } else {
                    result.add(reverse(list));
                }
                leftToRight = !leftToRight;

                list = new ArrayList<>();
                current = next;
                next = 0;
            }
        }
        return result;
    }

    private ArrayList<Integer> reverse(ArrayList<Integer> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            Integer temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        ArrayList<ArrayList<Integer>> lists = new PrintZigZag().Print(node);
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
