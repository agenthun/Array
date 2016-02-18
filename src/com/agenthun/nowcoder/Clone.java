package com.agenthun.nowcoder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by agenthun on 16/2/19.
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
 */
public class Clone {
    public RandomListNode Clone(RandomListNode pHead) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode p = pHead;
        RandomListNode q = new RandomListNode(-1);
        while (p != null) {
            RandomListNode t = new RandomListNode(p.label);
            map.put(p, t);
            p = p.next;
            q.next = t;
            q = t;
        }
        Set<Map.Entry<RandomListNode, RandomListNode>> set = map.entrySet();
        Iterator<Map.Entry<RandomListNode, RandomListNode>> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry<RandomListNode, RandomListNode> next = it.next();
            next.getValue().random = map.get(next.getKey().random);
        }
        return map.get(pHead);
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
