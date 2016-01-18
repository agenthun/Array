package com.agenthun.nowcoder;

/**
 * Created by agenthun on 16/1/18.
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        ListNode pReversedHead = head;
        ListNode pNode = head;
        ListNode pPrev = null;
        while (pNode != null) {
            ListNode pNext = pNode.next;
            if (pNext == null) pReversedHead = pNode;
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        return pReversedHead;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);

        ListNode resListNode = new ReverseList().ReverseList(listNode);
        while (resListNode != null) {
            System.out.print(resListNode.val + " ");
            resListNode = resListNode.next;
        }
    }
}
