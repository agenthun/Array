package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/9/9.
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 请写一个二分查找算法查找一个数最先出现的index，如果数不在集合中需要返回(-1)-当前数应该出现的位置。例如 [1,3,6],查找5,5应该是在index=2的位置但并不在集合中。返回(-1)-2 = -3。
 * 输入
 * 第一行读入一个整数x，表示要查找的数；第二行读入一个正整数n，表示待查找数组的元素个数；第三行读入n个递增整数，构成待查找的数组。
 * 输出
 * 整数x在数组中出现的索引位置(索引从0开始计数)；如果不存在，返回(-1)-当前数应该出现的位置。
 * <p>
 * 样例输入
 * 3
 * 5
 * 0 1 3 5 6
 * 样例输出
 * 2
 * in:
 * 5
 * 3
 * 1 3 6
 * out:
 * -3
 * <p>
 * in:
 * 3
 * 5
 * 0 1 3 5 6
 * out:
 * 2
 */
public class BinSearchII {
    public static int binarySearch(int[] a, int x, int begin, int end) {
        if (begin > end) return -1;
        while (begin <= end) {
            int mid = (end + begin) / 2;
            if (x == a[mid]) return mid;
            else if (x < a[mid]) end = mid - 1;
            else begin = mid + 1;
        }
        return -1 - begin;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            int res = binarySearch(a, x, 0, a.length - 1);
            System.out.println(res);
        }
    }
}
