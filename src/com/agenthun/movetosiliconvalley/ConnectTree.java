package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/12/6.
 */
public class ConnectTree {
    void connectTree(TreeLinkNode root) {
        TreeLinkNode currLevel = root;
        while (currLevel != null) {
            TreeLinkNode across = currLevel;
            while (across != null) {
                if (across.left != null) {
                    across.left.next = across.right;
                }
                if (across.right != null && across.next != null) {
                    across.right.next = across.next.left;
                }
                across = across.next;
            }
            currLevel = currLevel.left;
        }
    }

    class TreeLinkNode {
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
        int val;

        public TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
