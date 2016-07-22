package com.agenthun.nowcoder;

/**
 * Created by agenthun on 16/2/18.
 * 删除重复链表
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;

        ListNode p0 = new ListNode(0);
        p0.next = pHead;
        ListNode p1 = p0; //p1指向p0,p0后一结点为header
        while (p1.next != null && p1.next.next != null) { //p1的后一结点与再后者,存在且值相同
            if (p1.next.val == p1.next.next.val) { //值相同,删除
                int dup = p1.next.val; //取值
                while (p1.next != null && p1.next.val == dup) { //遍历p1后结点,值相同,跳两个
                    p1.next = p1.next.next;
                }
            } else { //值不同,跳过
                p1 = p1.next;
            }
        }
        return p0.next; //返回p0的后一结点,即header
    }
}
