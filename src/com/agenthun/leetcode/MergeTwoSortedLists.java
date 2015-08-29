package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/8/29.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode head = new ListNode(0);
        ListNode p = head;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) p.next = p1;
        if (p2 != null) p.next = p2;

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        for (int i = 1; i < 5; i++) {
            l1.addListNode(2 * i + 1);
        }
        l1.printListNode();

        ListNode l2 = new ListNode(0);
        for (int i = 1; i < 5; i++) {
            l2.addListNode(2 * i);
        }
        l2.printListNode();

        ListNode mergeListNode = new MergeTwoSortedLists().mergeTwoLists(l1, l2);
        mergeListNode.printListNode();
    }
}
