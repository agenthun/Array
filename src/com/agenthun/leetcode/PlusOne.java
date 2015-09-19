package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/9/19.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length < 1) return null;

        votate(digits, 0, digits.length - 1);
        int sum = digits[0] + 1;
        int count = sum / 10;
        digits[0] = sum % 10;
        for (int i = 1; i < digits.length; i++) {
            sum = digits[i] + count;
            digits[i] = sum % 10;
            count = sum / 10;
        }
        if (count == 0) {
            votate(digits, 0, digits.length - 1);
            return digits;
        } else {
            int[] result = new int[digits.length + 1];
            for (int i = 0; i < digits.length; i++) {
                result[i] = digits[i];
            }
            result[digits.length] = count;
            votate(result, 0, result.length - 1);
            return result;
        }
    }

    private void votate(int[] a, int left, int right) {
        while (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] num = {8, 9, 9, 9};
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
        System.out.println("plus one");
        int[] result = new PlusOne().plusOne(num);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
