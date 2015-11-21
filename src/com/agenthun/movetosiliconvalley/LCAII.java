package com.agenthun.movetosiliconvalley;

/**
 * Created by Henry on 2015/11/21.
 */
public class LCAII {
    TreeNode LCAII(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;

        TreeNode pq = new TreeNode(0);
        help(root, p, q, pq);
        TreeNode pp = pq.left, qq = pq.right;

        if (pp == null || qq == null) return null;
        int lenp = 0, lenq = 0;
        TreeNode up1 = pp, up2 = qq;

        while (up1 != root) {
            up1 = up1.parent;
            lenp++;
        }
        while (up2 != root) {
            up2 = up2.parent;
            lenq++;
        }
        up1 = pp;
        up2 = qq;

        while (lenp > lenq) {
            up1 = up1.parent;
            lenp--;
        }
        while (lenq > lenp) {
            up2 = up2.parent;
            lenq--;
        }

        while (up1 != up2) {
            up1 = up1.parent;
            up2 = up2.parent;
        }
        return up1;
    }

    private void help(TreeNode root, TreeNode p, TreeNode q, TreeNode pq) {
        if (root == null) return;
        if (root == p) pq.left = root;
        if (root == q) pq.right = root;

        if (pq.left == null || pq.right == null) {
            help(root.left, p, q, pq);
            help(root.right, p, q, pq);
        }
    }
}
