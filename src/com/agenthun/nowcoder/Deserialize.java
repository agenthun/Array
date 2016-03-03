package com.agenthun.nowcoder;

/**
 * Created by huheng on 3/3/2016.
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Deserialize {
    //Deserialize 序列化二叉树
    public int index = -1;

    String Serialize(TreeNode root) {
        StringBuffer stringBuffer = new StringBuffer();
        if (root == null) {
            stringBuffer.append("#,");
            return stringBuffer.toString();
        }
        stringBuffer.append(root.val + ",");
        stringBuffer.append(Serialize(root.left));
        stringBuffer.append(Serialize(root.right));
        return stringBuffer.toString();
    }

    TreeNode Deserialize(String str) {
        index++;
        int len = str.length();
        if (index >= len) {
            return null;
        }
        String[] strings = str.split(",");
        TreeNode node = null;
        if (!strings[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(strings[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        String str = new Deserialize().Serialize(root);
        System.out.println("new Deserialize().Serialize(root) = " + str);
        TreeNode node = new Deserialize().Deserialize(str);
    }
}
