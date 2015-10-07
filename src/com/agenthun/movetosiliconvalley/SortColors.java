package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/10/7.
 */
public class SortColors {
    int[] sortColors(int[] a) {
        int p0 = 0, p2 = a.length;
        for (int i = 0; i < p2; i++) {
            if (a[i] == 0) {
                int temp = a[p0];
                a[p0] = a[i];
                a[i] = temp;
                p0++;
            } else if (a[i] == 2) {
                p2--;
                int temp = a[p2];
                a[p2] = a[i];
                a[i] = temp;
                i--;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 0, 2, 1, 1, 2, 0, 2, 1, 0};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        int[] b = new SortColors().sortColors(a);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
    }
}
