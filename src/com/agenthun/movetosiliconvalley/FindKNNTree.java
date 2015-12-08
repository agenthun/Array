package com.agenthun.movetosiliconvalley;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by agenthun on 15/12/8.
 */
public class FindKNNTree {
    void findKNN(TreeNode root, int k, int target) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);
                if (abs2 > abs1) return 1;
                else if (abs2 < abs1) return -1;
                else return 0;
            }
        };
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, comparator);
        findKNN(root, k, target, heap);
        Iterator<Integer> it = heap.iterator();
        while (it.hasNext()) {
            System.out.println(it.next() + target);
        }
    }

    private void findKNN(TreeNode root, int k, int target, PriorityQueue<Integer> heap) {
        if (root == null) return;
        findKNN(root.left, k, target, heap);
        if (heap.size() < k) heap.add(root.val - target);
        else {
            int diff = Math.abs(root.val - target);
            int maxDiff = Math.abs(heap.peek());
            if (maxDiff > diff) {
                heap.poll();
                heap.add(root.val - target);
            }
        }
        findKNN(root.right, k, target, heap);
    }
}
