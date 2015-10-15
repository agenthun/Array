package com.agenthun.movetosiliconvalley;

import java.util.Random;

/**
 * Created by agenthun on 15/10/16.
 */
public class PickK {
    int[] pickK(int[] A, int k) {
        int[] buf = new int[k];
        for (int i = 0; i < A.length; i++) {
            if (i < k) {
                buf[i] = A[i];
            } else {
                Random random = new Random(i);
                int index = random.nextInt();
                if (index < k) {
                    buf[index] = A[i];
                }
            }
        }
        return buf;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 8, 6, 4, 2, 0};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        int k = 10;
        System.out.println("k = " + k);
        int[] result = new PickK().pickK(a, k);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
