package com.agenthun.nowcoder;

import java.util.Arrays;

/**
 * Created by agenthun on 16/1/26.
 */
public class VerifySquenceOfBST {
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;

        int root = sequence[sequence.length - 1];

        int cut = 0;

        for (int i = 0; i < sequence.length - 1; i++) {
            if (sequence[i] > root) {
                cut = i + 1;
                break;
            }
        }
        if (cut == 0)
            VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, sequence.length - 1));
        else {
            for (int i = cut; i < sequence.length - 1; i++) {
                if (sequence[i] <= root) return false;
            }
            VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, cut));
            VerifySquenceOfBST(Arrays.copyOfRange(sequence, cut, sequence.length - 1));
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6, 4, 7, 7, 9, 8, 2};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        System.out.println("VerifySquenceOfBST(a) = " + VerifySquenceOfBST(a));
    }
}
