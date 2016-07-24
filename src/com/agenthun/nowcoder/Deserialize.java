package com.agenthun.nowcoder;

/**
 * Created by huheng on 3/3/2016.
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Deserialize {
    //Deserialize 序列化二叉树
    public int index = -1; //为反序列化位置指针

    String Serialize(TreeNode root) {
        StringBuffer stringBuffer = new StringBuffer();
        if (root == null) {
            stringBuffer.append("#,"); //序列化,标志#,间隔,
            return stringBuffer.toString();
        }
        stringBuffer.append(root.val + ",");
        stringBuffer.append(Serialize(root.left)); //递归左结点
        stringBuffer.append(Serialize(root.right)); //递归右结点
        return stringBuffer.toString();
    }

    TreeNode Deserialize(String str) {
        index++;
        int len = str.length();
        if (index >= len) { //判断位置指针是否有效
            return null;
        }
        String[] strings = str.split(",");
        TreeNode node = null;
        if (!strings[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(strings[index]));
            node.left = Deserialize(str); //递归左结点
            node.right = Deserialize(str); //递归右结点
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
