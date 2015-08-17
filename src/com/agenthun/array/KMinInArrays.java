package com.agenthun.array;

/**
 * Created by Agent Henry on 2015/8/17.
 */
public class KMinInArrays {

    public static int kMinInArrays(int[] a, int aBegin, int aEnd, int[] b, int bBegin, int bEnd, int k) {
        int aLen = aEnd - aBegin + 1;
        int bLen = bEnd - bBegin + 1;
        if (aLen == 0) return b[bBegin + k - 1];
        if (bLen == 0) return a[aBegin + k - 1];
        if (k == 1) return Math.min(a[aBegin], b[bBegin]);

        int pa = Math.min(k / 2, aLen), pb = k - pa;
        if (a[aBegin + pa - 1] < b[bBegin + pb - 1]) {
            aBegin += pa;
            k -= pa;
        } else {
            bBegin += pb;
            k -= pb;
        }
        return kMinInArrays(a, aBegin, aEnd, b, bBegin, bEnd, k);
    }

    public static void main(String[] args) {
        int[] a1 = {1, 3, 5, 7, 9};
        int[] a2 = {2, 4, 6, 8};
        for (int i = 0; i < a1.length; i++) {
            System.out.print(a1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < a2.length; i++) {
            System.out.print(a2[i] + " ");
        }
        System.out.println();

        int k = 7;
        System.out.println("KMinInArrays(" + k + ") = " + kMinInArrays(a1, 0, a1.length - 1, a2, 0, a2.length - 1, k));
    }
}
