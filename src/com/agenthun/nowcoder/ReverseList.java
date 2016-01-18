package com.agenthun.nowcoder;

import java.util.Stack;

/**
 * Created by agenthun on 16/1/18.
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode pNode = new ListNode(0);
        ListNode pp = pNode;
        while (!stack.isEmpty()) {
            pp.next = stack.pop();
            pp = pp.next;
        }
        return pNode;
    }
}
