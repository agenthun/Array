package com.agenthun.movetosiliconvalley;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by agenthun on 15/12/10.
 */
public class ZizaglevelOrder {
    ArrayList<ArrayList<Integer>> zizaglevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        LinkedList<TreeNode> currLevel = new LinkedList<>();
        currLevel.add(root);

        boolean leftToRight = true;
        while (currLevel.size() > 0) {
            ArrayList<Integer> currList = new ArrayList<>();
            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            while (currLevel.size() > 0) {
                TreeNode node = currLevel.poll();
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
                if (leftToRight) {
                    currList.add(node.val);
                } else {
                    currList.add(0, node.val);
                }
            }
            res.add(currList);
            currLevel = nextLevel;
            leftToRight = !leftToRight;
        }
        return res;
    }
}
