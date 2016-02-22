package com.agenthun.nowcoder;

/**
 * Created by agenthun on 16/2/23.
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 */
public class InversePairs {
    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) return 0;

/*        //solution 1
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) count++;
            }
        }
        return count;*/

        //solution 2
        int length = array.length;
        int count = 0;
        for (int i = length - 1; i > 0; i--) {
            if (array[i] < array[i - 1]) {
                count++;
            }
        }
        return (count * count + count) >> 1;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 2, 5, 4, 1};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("InversePairs(a) = " + new InversePairs().InversePairs(a));
    }
}
