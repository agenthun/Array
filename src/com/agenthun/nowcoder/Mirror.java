package com.agenthun.nowcoder;

/**
 * Created by agenthun on 16/1/22.
 */
public class Mirror {
    public static void mirror(TreeNode root) {
        /*        if (root == null) return;
                TreeNode sroot, droot;

		        sroot = root;
		        while (sroot != null) {

		        }*/

        //递归
        if (root == null) return;
        TreeNode pTemp = root.left;
        root.left = root.right;
        root.right = pTemp;

        mirror(root.left);
        mirror(root.right);
        return;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        mirror(node);

    }
}
