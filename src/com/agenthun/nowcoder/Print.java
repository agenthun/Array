package com.agenthun.nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by agenthun on 16/2/13.
 */
public class Print {
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;

        ArrayList<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int current = 1;
        int next = 0;

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
                result.add(list);
                list = new ArrayList<>();
                current = next;
                next = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        ArrayList<ArrayList<Integer>> lists = Print(node);
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
