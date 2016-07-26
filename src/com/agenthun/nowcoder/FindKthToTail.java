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

    public ListNode FindKthToTail2(ListNode head, int k) {
        if (head == null) return null;
        if (k < 1) return null;

        ListNode p1 = head;
        ListNode p2 = head;
        while (p1 != null && k > 0) { //先遍历p1的k个
            p1 = p1.next;
            k--;
        }
        if (k > 0) {
            return null;  //判断k是否超过p1长度
        } else {
            while (p1 != null) { //同时遍历p1,p2,直到p1结束,即len-k个
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return p2;
    }
}
