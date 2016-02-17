package com.agenthun.nowcoder;

/**
 * Created by agenthun on 16/2/18.
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;

        ListNode p0 = new ListNode(0);
        p0.next = pHead;
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
}
