package com.agenthun.nowcoder;

/**
 * Created by agenthun on 16/2/17.
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;

        if (pNode.right != null) return getLeftMost(pNode.right);
        else {
            TreeLinkNode p = pNode.next;
            while (p != null && p.left != pNode) {
                pNode = p;
                p = pNode.next;
            }
            return p;
        }
    }

    private TreeLinkNode getLeftMost(TreeLinkNode treeLinkNode) {
        TreeLinkNode res = treeLinkNode;
        while (res.left != null) res = res.left;
        return res;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
