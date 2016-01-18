package com.agenthun.nowcoder;

import java.util.List;

/**
 * Created by agenthun on 16/1/18.
 */
public class Merge {
    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode mergeHead = null;
        if (list1.val <= list2.val) {
            mergeHead = list1;
            mergeHead.next = merge(list1.next, list2);
        } else {
            mergeHead = list2;
            mergeHead.next = merge(list1, list2.next);
        }
        return mergeHead;
    }
}
