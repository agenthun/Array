package com.agenthun.schoolrecruit2016;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by agenthun on 16/3/31.
 * 对于一个由0..n的所有数按升序组成的序列，我们要进行一些筛选，每次我们取当前所有数字中从小到大的第奇数位个的数，并将其丢弃。
 * 重复这一过程直到最后剩下一个数。请求出最后剩下的数字。
 * 输入描述:每组数据一行一个数字，为题目中的n(n小于等于1000)。
 * 输出描述:一行输出最后剩下的数字。
 * 输入例子:
 * 500
 * 输出例子:
 * 255
 */
public class OddBitDrop {
    private static int oddBitDrop(int n) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            list.add(i);
        }

        int len = list.size();
        while (len > 1) {
            int k = 0;
            for (int i = 0; i < len; i++) {
                if ((i & 0x1) == 0) {
                    list.remove(k);
                    k++;
                }
            }
            len = list.size();
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(oddBitDrop(n));
        }
    }
}
