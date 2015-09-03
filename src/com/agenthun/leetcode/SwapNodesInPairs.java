package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/9/3.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = new ListNode(0);
        ListNode p1 = p;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            ListNode temp = p2.next.next;
            p2.next.next = p2;
            p1.next = p2.next;
            p2.next = temp;
            p1 = p2;
            p2 = p2.next;
        }
        return p.next;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.addListNode(2);
        list.addListNode(3);
        list.addListNode(4);
        list.printListNode();
        ListNode result = new SwapNodesInPairs().swapPairs(list);
        result.printListNode();
    }
}
