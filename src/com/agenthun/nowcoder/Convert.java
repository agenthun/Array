package com.agenthun.nowcoder;

/**
 * Created by agenthun on 16/2/21.
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 即中序遍历
 */
public class Convert {
    private TreeNode leftLast = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;

        //无子结点
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            leftLast = pRootOfTree;
            return pRootOfTree;
        }

        TreeNode left = Convert(pRootOfTree.left); //遍历到左结点,递归
        if (left != null) { //链:leftLast <-> pRootOfTree
            leftLast.right = pRootOfTree;
            pRootOfTree.left = leftLast;
        }
        leftLast = pRootOfTree;

        TreeNode right = Convert(pRootOfTree.right);//遍历到右结点,递归
        if (right != null) {//链:pRootOfTree <-> right
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left != null ? left : pRootOfTree; //left若为null,则left=pRootOfTree
    }
}
