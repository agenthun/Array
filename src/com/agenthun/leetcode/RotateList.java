package com.agenthun.leetcode;

/**
 * Created by agenthun on 15/9/26.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode p = new ListNode(-1);
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode temp = head;
        int len = 0;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        k %= len;
        if (k == 0) return head;

        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p = p2.next;
        p1.next = head;
        p2.next = null;

        return p;
    }

    public static void main(String[] args) {
        int k = 3;
        System.out.println("k = " + k);
        ListNode listNode = new ListNode(1);
        listNode.addListNode(2);
        listNode.addListNode(3);
        listNode.addListNode(4);
        listNode.addListNode(5);
        listNode.printListNode();

        ListNode result = new RotateList().rotateRight(listNode, k);
        result.printListNode();
    }
}
