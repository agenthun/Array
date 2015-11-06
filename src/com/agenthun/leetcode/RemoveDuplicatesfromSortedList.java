package com.agenthun.leetcode;

/**
 * Created by agenthun on 15/11/6.
 */
public class RemoveDuplicatesfromSortedList {
    ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode p = head;

        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.addListNode(1);
        listNode.addListNode(2);
        listNode.addListNode(3);
        listNode.addListNode(3);
        listNode.printListNode();

        ListNode result = new RemoveDuplicatesfromSortedList().deleteDuplicates(listNode);
        result.printListNode();
    }
}
