package com.agenthun.movetosiliconvalley;

import javax.swing.tree.TreeNode;
import java.util.Stack;

/**
 * Created by agenthun on 15/10/31.
 */
public class InOrderIteratively {
    void inOrderIteratively(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s = new Stack<>();
        pushLeft(s, root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
/*            System.out.print(node.value + " ");
            pushLeft(s, node.right);*/
        }
    }

    void pushLeft(Stack<TreeNode> s, TreeNode node) {
        while (node != null) {
            s.push(node);
/*            node = node.left;*/
        }
    }
}
