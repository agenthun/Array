package com.agenthun.leetcode;

import java.util.List;

/**
 * Created by Agent Henry on 2015/8/10.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode l1Temp = l1, l2Temp = l2, l3Temp = head;

        while (l1Temp != null || l2Temp != null) {
            if (l1Temp != null) {
                carry += l1Temp.val;
                l1Temp = l1Temp.next;
            }
            if (l2Temp != null) {
                carry += l2Temp.val;
                l2Temp = l2Temp.next;
            }
            l3Temp.next = new ListNode(carry % 10);
            l3Temp = l3Temp.next;
            carry /= 10;
        }
        if (carry > 0) {
            l3Temp.next = new ListNode(carry);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.printListNode(l1);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.printListNode(l2);

        ListNode l12 = new AddTwoNumbers().addTwoNumbers(l1, l2);
        l12.printListNode(l12);
    }

}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public void printListNode(ListNode listNode) {
        ListNode temp = listNode;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
