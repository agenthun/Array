package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/9/3.
 * 调整链表顺序使奇数位于偶数前面,保持相反的稳定性
 * 将链表中的所有元素为奇数的节点移到元素为偶数节点的前面，并使奇数之间顺序反转，偶数之间顺序反转。
 * 示例：
 * 交换前链表的顺序		交换后链表的顺序
 * 4→5→7→1→6   ==>  1→7→5→6→4
 * 1                ==>  1			（链表仅含一个元素)
 * 2→1            ==>  1→2
 * ==>				(链表为空)
 * 链表节点定义为：
 * class Node {
 * public Node next;
 * public int value;
 * }
 * Node swap(Node list)
 * 注意点和要求如下:
 * 1. swap函数要求对节点的指针/引用进行操作（不得创建任何新的链表节点）
 * 2. 不得使用任何库函数/API，如需使用类似功能, 请自行实现
 * 3. 不得将链表转化为其他类型数据结构再进行交换，如数组等
 */
public class ReOrderNode {

    static class Node {
        public Node next;
        public int value;

        Node(int value) {
            this.value = value;
        }
    }

    //交换链表结点,使奇数位于偶数前面,保持相反的稳定性
    public static Node swap(Node list) {
        if (list == null) return null; //链表为空
        if (list.next == null) return list; //仅含一个元素

        Node cur = list;
        Node pre = null;
        Node evenNode = null;

        //使偶数在奇数前面
        while (cur != null) {
            if ((cur.value & 0x1) == 0) {//偶数
                //第一个偶数
                if (evenNode == null) {
                    if (cur != list) {
                        pre.next = cur.next;
                        cur.next = list;
                        list = cur;
                        evenNode = cur;
                        cur = pre;
                    } else { //是第一个结点
                        evenNode = cur;
                    }
                } else {
                    if (pre == evenNode) {
                        evenNode = cur;
                    } else {
                        pre.next = cur.next;
                        cur.next = evenNode.next;
                        evenNode.next = cur;
                        evenNode = cur;
                        cur = pre;
                    }
                }
            }
            pre = cur;
            cur = cur.next;
        }

        //反转链表
        list = reverseList(list);
        return list;
    }

    //反转链表
    public static Node reverseList(Node head) {
        if (head == null) return null;
        Node pReversedHead = head;
        Node pNode = head;
        Node pPrev = null;
        while (pNode != null) {
            Node pNext = pNode.next;
            if (pNext == null) pReversedHead = pNode;
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        return pReversedHead;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt(); //获取输入链表长度
            int[] v = new int[n]; //获取输入链表各结点值
            for (int i = 0; i < n; i++) {
                v[i] = scanner.nextInt();
            }

            //由数组建立链表
            Node head = new Node(v[0]);
            bulidNode(head, v);

            //调整链表顺序
            head = swap(head);

            //打印调整后的链表
            printNode(head);
        }
    }

    //由数组建立链表
    private static void bulidNode(Node root, int[] v) {
        for (int i = 1; i < v.length; i++) {
            Node node = new Node(v[i]);
            root.next = node;
            root = node;
        }
    }

    //打印链表
    private static void printNode(Node root) {
        while (root != null) {
            System.out.print(root.value + " ");
            root = root.next;
        }
        System.out.println();
    }
}
