package com.agenthun.leetcode;

/**
 * Created by agenthun on 15/11/8.
 */
public class RemoveDuplicatesfromSortedListII {
    ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode p0 = new ListNode(0);
        p0.next = head;

        ListNode p1 = p0;
        while (p1.next != null && p1.next.next != null) {
            if (p1.next.val == p1.next.next.val) {
                int dup = p1.next.val;
                while (p1.next != null && p1.next.val == dup) {
                    p1.next = p1.next.next;
                }
            } else {
                p1 = p1.next;
            }
        }

        return p0.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.addListNode(2);
        listNode.addListNode(3);
        listNode.addListNode(3);
        listNode.addListNode(3);
        listNode.addListNode(4);
        listNode.addListNode(5);
        listNode.printListNode();

        ListNode result = new RemoveDuplicatesfromSortedListII().deleteDuplicates(listNode);
        result.printListNode();
    }
}
