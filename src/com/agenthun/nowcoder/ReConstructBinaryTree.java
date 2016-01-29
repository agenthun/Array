package com.agenthun.nowcoder;

import java.util.Arrays;

/**
 * Created by agenthun on 16/1/29.
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
 */
public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) throws Exception {
        if (pre == null || in == null) return null;

        int rootData = pre[0];
        TreeNode root = new TreeNode(rootData);

        int rootInIndex = 0;
        int temp = in[rootInIndex];
        while (rootInIndex < in.length && rootData != temp) {
            rootInIndex++;
            temp = in[rootInIndex];
        }

        if (rootInIndex == in.length && rootData != in[rootInIndex - 1]) {
            throw new Exception();
        }

        if (rootInIndex > 0) {
            root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, rootInIndex + 1), Arrays.copyOfRange(in, 0, rootInIndex));
        }
        if (rootInIndex < in.length - 1) {
            root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, rootInIndex + 1, pre.length), Arrays.copyOfRange(in, rootInIndex + 1, in.length));
        }
        return root;
    }
}
