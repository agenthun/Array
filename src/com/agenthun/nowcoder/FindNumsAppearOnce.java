package com.agenthun.nowcoder;

/**
 * Created by huheng on 1/28/2016.
 * 数组只有2个数出现一次,其它出现两次,求这2个出现一次的数
 */
public class FindNumsAppearOnce {
    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length <= 1) return;
        int temp = 0;
        int maskBit = 1;
        //只出现一次,异或最后不为0,两两相同异或为0
        for (int i = 0; i < array.length; i++) {
            temp ^= array[i];
        }
        //找出第几位不一样,为1
        while ((temp & maskBit) == 0) {
            maskBit = maskBit << 1;
        }
        num1[0] = 0;
        num2[0] = 0;
        //分两批,该位为1,该位不为1,各异或,结果即这两数
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & maskBit) == 0) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    public static void main(String[] args) {
//        int[] a = {1, 0, 1, 5, 4, 3, 4, 9, 5, 3, 7, 0};
        int[] a = {1, 2};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        int[] res1 = new int[1];
        int[] res2 = new int[1];

        FindNumsAppearOnce(a, res1, res2);

        System.out.println("res1 = " + res1[0]);
        System.out.println("res2 = " + res2[0]);
    }
}
