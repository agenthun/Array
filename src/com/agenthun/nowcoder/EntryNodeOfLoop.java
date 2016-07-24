package com.agenthun.nowcoder;

/**
 * Created by agenthun on 16/2/14.
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return null;

        //两个指针,一个快,走2步,一个慢,走1步
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break; //快慢指针相同,返回慢指针
        }
        if (fast == null || fast.next == null) return null;
        slow = pHead;
        while (slow != fast) { //快慢指针不同时循环,同时走1步
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
