package com.agenthun.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Agent Henry on 2015/9/3.
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        PriorityQueue<ListNode> q = new PriorityQueue<>(lists.length,
                new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode o1, ListNode o2) {
                        if (o1.val > o2.val) return 1;
                        else if (o1.val == o2.val) return 0;
                        else return -1;
                    }
                });

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) q.add(lists[i]);
        }

        ListNode head = new ListNode(0);
        ListNode p = head;
        while (q.size() > 0) {
            ListNode temp = q.poll();
            p.next = temp;

            if (temp.next != null) q.add(temp.next);
            p = p.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        int k = 4;
        ListNode[] listNodes = new ListNode[k];
        for (int i = 0; i < k; i++) {
            listNodes[i] = new ListNode(i);
            listNodes[i].addListNode(i * 2 + 1);
            listNodes[i].addListNode(i * 2 + 3);
            listNodes[i].addListNode(i * 2 + 5);
        }
        System.out.println("k = " + k);
        for (int i = 0; i < k; i++) {
            listNodes[i].printListNode();
        }

        ListNode list = new MergeKSortedLists().mergeKLists(listNodes);
        list.printListNode();
    }
}
