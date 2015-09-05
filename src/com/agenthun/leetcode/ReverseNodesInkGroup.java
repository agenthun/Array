package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/9/5.
 */
public class ReverseNodesInkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy, cross = head;
        int count = 0;
        while (cross != null) {
            count++;
            if (count % k == 0) {
                pre = reverse(pre, cross.next);
                cross = pre.next;
            } else {
                cross = cross.next;
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode pre, ListNode next) {
        ListNode last = pre.next;
        ListNode cur = last.next;
        while (cur != next) {
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }

    public static void main(String[] args) {
        int k = 2;
        ListNode listNode = new ListNode(1);
        listNode.addListNode(2);
        listNode.addListNode(3);
        listNode.addListNode(4);
        listNode.addListNode(5);
        listNode.printListNode();
        System.out.println("k = " + k);
        ListNode result = new ReverseNodesInkGroup().reverseKGroup(listNode, k);
        result.printListNode();
    }
}
