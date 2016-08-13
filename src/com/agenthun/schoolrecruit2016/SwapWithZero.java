package com.agenthun.schoolrecruit2016;

/**
 * Created by Daydreamer on 2016/8/13.
 * 长度为n的数组乱序存放着0至n-1. 现在只能进行0与其他数的交换，完成以下函数
 */
public class SwapWithZero {
    /**
     * 交换数组里n和0的位置
     *
     * @param array 数组
     * @param len   数组长度
     * @param n     和0交换的数
     */
    // 不要修改以下函数内容
    public void swapWithZero(int[] array, int len, int n) {
//       SwapWithZero(array, len, n);
    }
    // 不要修改以上函数内容


    /**
     * 通过调用swapWithZero方法来排
     *
     * @param array 存储有[0,n)的数组
     * @param len   数组长度
     */
    public void sort(int[] array, int len) {
        // 完成这个函数
        int count = len - 1;
        while (count > 0) {
            swapWithZero(array, len, array[count]);
            swapWithZero(array, len, count);
            count--;
        }
    }
}

