package com.agenthun.nowcoder;

/**
 * Created by agenthun on 16/1/17.
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) return null;
        if (k < 1) return null;
        ListNode hl = head;
        int l = 0;
        while (hl != null) {
            hl = hl.next;
            l++;
        }
        if (l < k) return null;

        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
