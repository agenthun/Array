package com.agenthun.schoolrecruit2016;

import java.util.*;

/**
 * Created by agenthun on 16/6/20.
 * 小Q今天在上厕所时想到了这个问题：有n个数，两两组成二元组，差最小的有多少对呢？差最大呢？
 * 输入描述:
 * 输入包含多组测试数据。
 * 对于每组测试数据：
 * N - 本组测试数据有n个数
 * a1,a2...an - 需要计算的数据
 * 保证:
 * 1<=N<=100000,0<=ai<=INT_MAX.
 * 输出描述:
 * 对于每组数据，输出两个数，第一个数表示差最小的对数，第二个数表示差最大的对数。
 * 输入例子:
 * 6
 * 45 12 45 32 5 6
 * 输出例子:
 * 1 2
 */
public class MinMaxNumberCouple {
    public static String getNumber(int[] input, int n) {
        if (input == null || n != input.length || n < 2)
            return null;
        Arrays.sort(input);
        int maxpair = 0;
        int minpair = 0;
        int low = 0;
        int high = n - 1;
        if (input[low] == input[high]) {
            maxpair = n * (n - 1) / 2;
            minpair = maxpair;
        } else {
            while (low < n) {
                if (input[low] == input[0])
                    low++;
                else
                    break;
            }
            while (high < n) {
                if (input[high] == input[n - 1])
                    high--;
                else
                    break;
            }
            int beginlen = low;
            int endlen = n - 1 - high;
            maxpair = beginlen * endlen;
            int min = Integer.MAX_VALUE;
            low = 0;
            high = 1;
            while (low < n && high < n) {
                if (input[high] - input[low] < min) {
                    min = input[high] - input[low];
                }
                if (min == 0)
                    break;
                low++;
                high++;
            }
            if (min == 0) {
                int thesame = 1;
                low = 0;
                high = 1;
                while (high < n) {
                    if (input[high] == input[low])
                        thesame++;
                    else {
                        minpair += thesame * (thesame - 1) / 2;
                        thesame = 1;
                    }
                    if (high == n - 1) {
                        minpair += thesame * (thesame - 1) / 2;
                        break;
                    }
                    low++;
                    high++;
                }
            } else {
                low = 0;
                high = 1;
                while (high < n) {
                    if (input[high] - input[low] == min)
                        minpair++;
                    low++;
                    high++;
                }
            }
        }
        String result = minpair + " " + maxpair;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> al = new ArrayList<>();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] input = new int[n];
            for (int i = 0; i < n; ++i) {
                input[i] = sc.nextInt();
            }
            al.add(getNumber(input, n));
        }
        for (String cur : al) {
            System.out.println(cur);
        }
    }
}
