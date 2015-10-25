package com.agenthun.movetosiliconvalley;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by agenthun on 15/10/25.
 */
public class MaxSlidingWindow {
    private class Pair {
        int val;
        int index;

        public Pair(int v, int i) {
            val = v;
            index = i;
        }
    }

    void maxSlidingWindow(int[] a, int w, int[] b) {
        int n = a.length;
        Comparator<Pair> comparator = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.val < o2.val) return 1;
                else if (o1.val > o2.val) return -1;
                else if (o1.index > o2.index) return -1;
                else if (o1.index < o2.index) return 1;
                else
                    return 0;
            }
        };

        PriorityQueue<Pair> q = new PriorityQueue<Pair>(w, comparator);
        for (int i = 0; i < w; i++) {
            q.offer(new Pair(a[i], i));
        }

        for (int i = w; i < n; i++) {
            Pair p = q.peek();
            b[i - w] = p.val;
            while (p.index <= i - w) {
                q.poll();
                p = q.peek();
            }
            q.add(new Pair(a[i], i));
        }
        b[n - w] = q.peek().val;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
        int w = 3;
        int[] result = new int[a.length - w + 1];

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        new MaxSlidingWindow().maxSlidingWindow(a, w, result);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
