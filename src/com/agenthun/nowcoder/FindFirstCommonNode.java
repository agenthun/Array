package com.agenthun.nowcoder;

/**
 * Created by agenthun on 16/1/16.
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        //pHead1长度
        ListNode tail1 = pHead1;
        int len1 = 1;
        while (tail1.next != null) {
            tail1 = tail1.next;
            len1++;
        }
        //pHead2长度
        ListNode tail2 = pHead2;
        int len2 = 1;
        while (tail2.next != null) {
            tail2 = tail2.next;
            len2++;
        }

        if (tail1 != tail2) return null;

        ListNode t1 = pHead1;
        ListNode t2 = pHead2;
        if (len1 > len2) {
            int d = len1 - len2;
            while (d != 0) {
                t1 = t1.next;
                d--;
            }
        } else {
            int d = len2 - len1;
            while (d != 0) {
                t2 = t2.next;
                d--;
            }
        }

        while (t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;
        }
        return t1;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
