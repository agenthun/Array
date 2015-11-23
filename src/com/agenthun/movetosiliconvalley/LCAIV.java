package com.agenthun.movetosiliconvalley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by agenthun on 15/11/23.
 */
public class LCAIV {
    class TreeNode {
        int val;
        ArrayList<TreeNode> children;
    }

    TreeNode LCAIV(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;

        Queue<TreeNode> currLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();
        currLevel.offer(root);
        Queue<TreeNode> pp = new LinkedList<>();
        Queue<TreeNode> qq = new LinkedList<>();
        HashMap<TreeNode, TreeNode> backTracking = new HashMap<>();

        while (!currLevel.isEmpty()) {
            while (!currLevel.isEmpty()) {
                nextLevel = new LinkedList<>();
                TreeNode node = currLevel.poll();
                for (TreeNode child :
                        node.children) {
                    backTracking.put(child, node);
                    if (child == p) addParent(pp, p, backTracking);
                    else if (child == q) addParent(qq, q, backTracking);
                    if (!pp.isEmpty() && !qq.isEmpty()) {
                        return getLCA(pp, qq);
                    } else {
                        nextLevel.offer(child);
                    }
                }
            }
            currLevel = nextLevel;
        }
        return null;
    }

    private void addParent(Queue<TreeNode> queue, TreeNode q, HashMap<TreeNode, TreeNode> backTracking) {
        TreeNode parent = backTracking.get(q);
        while (parent != null) {
            queue.add(parent);
            parent = backTracking.get(parent);
        }
    }

    private TreeNode getLCA(Queue<TreeNode> pp, Queue<TreeNode> qq) {
        TreeNode result = null;
        while (!pp.isEmpty() && !qq.isEmpty()) {
            TreeNode pParent = pp.poll();
            TreeNode qParent = qq.poll();
            if (pParent == qParent) {
                result = pParent;
            } else {
                break;
            }
        }
        return result;
    }
}
