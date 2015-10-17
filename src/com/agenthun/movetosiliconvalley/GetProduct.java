package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/10/17.
 */
public class GetProduct {
    int[] getProduct(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (i == 0) b[i] = 1;
            else b[i] = b[i - 1] * a[i - 1];
        }
        int right = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            b[i] = b[i] * right;
            right = a[i] * right;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        int[] b = new GetProduct().getProduct(a);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
    }
}
