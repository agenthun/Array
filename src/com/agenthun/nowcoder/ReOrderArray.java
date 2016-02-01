package com.agenthun.nowcoder;

/**
 * Created by agenthun on 16/1/31.
 * 调整数组顺序使奇数位于偶数前面
 */
public class ReOrderArray {
    public static void reOrderArray(int[] array) {
        if (array == null || array.length == 0) return;
//        quickSortByOddOvenOrder(array, 0, array.length - 1);
        mergeSortByOddOvenOrder(array, 0, array.length - 1);

        //再次反序输出=>正序
        int i = 0, j = array.length - 1;
        while (i < j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }

    //基于堆排, 稳定
    private static void mergeSortByOddOvenOrder(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) >> 1;
            mergeSortByOddOvenOrder(array, left, mid);
            mergeSortByOddOvenOrder(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    //反序输出
    private static void merge(int[] array, int left, int mid, int right) {
/*        int i, j, k, n1, n2;
        n1 = mid - left + 1;
        n2 = right - mid;
        int[] l = new int[n1];
        int[] r = new int[n2];

        for (i = 0, k = left; i < n1; i++, k++) {
            l[i] = array[k];
        }
        for (i = 0, k = mid + 1; i < n2; i++, k++) {
            r[i] = array[k];
        }

        for (k = left, i = 0, j = 0; i < n1 && j < n2; k++) {
            if ((l[i] % 2 == 0) && (r[j] % 2 == 1)) {
                array[k] = l[i];
                i++;
            } else {
                array[k] = r[j];
                j++;
            }
        }
        if (i < n1) {
            for (j = i; j < n1; j++, k++) {
                array[k] = l[j];
            }
        }
        if (j < n2) {
            for (i = j; i < n2; i++, k++) {
                array[k] = r[i];
            }
        }*/

        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
//            if ((array[i] % 2 == 1) && (array[j] % 2 == 0)) //偶数在前
            if ((array[i] % 2 == 0) && (array[j] % 2 == 1)) {//奇数在前
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }

        for (int l = 0; l < temp.length; l++) {
            array[l + left] = temp[l];
        }
    }

    //基于快排, 但不稳定
    private static void quickSortByOddOvenOrder(int[] array, int left, int right) {
        int i, j;
        int index;
        if (left >= right) return;
        i = left;
        j = right;
        index = array[i];
        while (i < j) {
            while (i < j && (array[j] % 2 == 0)) j--;
            if (i < j) array[i++] = array[j];
            while (i < j && (array[i] % 2 == 1)) i++;
            if (i < j) array[j--] = array[i];
        }
        array[i] = index;
        quickSortByOddOvenOrder(array, left, i - 1);
        quickSortByOddOvenOrder(array, i + 1, right);
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 2, 11, 4, 5, 13, 8, 9, 10};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\nresult = ");

        reOrderArray(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
