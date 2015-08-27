package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/8/27.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;

        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        if (first == null) return head.next;
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.printListNode(listNode);
        System.out.println();

        int n = 3;
        System.out.println("n = " + n);
        ListNode res = new RemoveNthNodeFromEndOfList().removeNthFromEnd(listNode, n);
        res.printListNode(res);
    }
}
