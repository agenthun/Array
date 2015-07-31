package com.agenthun.array;

/**
 * Created by Agent Henry on 2015/7/31.
 */
public class BinarySearch {
    public static int binarySearch(int[] a, int x, int begin, int end) {
        if (begin > end) return -1;
        while (begin <= end) {
            int mid = (end + begin) / 2;
            if (x == a[mid]) return mid;
            else if (x < a[mid]) end = mid - 1;
            else begin = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 9, 17};
        System.out.println("search '2' index = " + binarySearch(a, 2, 0, a.length - 1));
    }
}
