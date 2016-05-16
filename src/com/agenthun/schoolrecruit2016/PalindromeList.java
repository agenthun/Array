package com.agenthun.schoolrecruit2016;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by agenthun on 16/5/11.
 * 对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
 * 给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
 * 测试样例：
 * 1->2->2->1
 * 返回：true
 */
public class PalindromeList {
    //数据进入一个队列,一个栈;分别出来比较
    public boolean chkPalindrome(ListNode A) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        while (A != null) {
            stack.push(A.val);
            queue.add(A.val);
            A = A.next;
        }
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.poll())) break;
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}