package com.agenthun.schoolrecruit2016;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by agenthun on 16/8/1.
 * 构造队列
 * Time Limit: 4000/2000 MS (Java/Others) Memory Limit: 65536/65536 K (Java/Others)
 * Problem Description:
 * 小明同学把1到n这n个数字按照一定的顺序放入了一个队列Q中。现在他对队列Q执行了如下程序：
 * while(!Q.empty())              //队列不空，执行循环
 * {
 * int x=Q.front();            //取出当前队头的值x
 * Q.pop();                 //弹出当前队头
 * Q.push(x);               //把x放入队尾
 * x=Q.front();              //取出这时候队头的值
 * printf("%d\n",x);          //输出x
 * Q.pop();                 //弹出这时候的队头
 * }
 * 做取出队头的值操作的时候，并不弹出当前队头。
 * 小明同学发现，这段程序恰好按顺序输出了1,2,3,...,n。现在小明想让你构造出原始的队列，你能做到吗？
 * 输入
 * 第一行一个整数T（T<=100）表示数据组数，每组数据输入一个数n（1<=n<=100000），输入的所有n之和不超过200000。
 * 输出
 * 对于每组数据，输出一行，表示原始的队列。数字之间用一个空格隔开，不要在行末输出多余的空格。
 * <p>
 * 样例输入
 * 4
 * 1
 * 2
 * 5
 * 10
 * 样例输出
 * 1
 * 2 1
 * 2 1 3
 * 8 1 6 2 10 3 7 4 9 5
 */
public class BuildJosephArray {
    public static int joseph(int n, int m) {
        if (n <= 0 || m < 0) return -1;

        int fn = 0;
        if (n != 1) {
            for (int i = 2; i <= n; i++) {
                System.out.print((fn + m) / i);
                fn = (fn + m) % i;
                System.out.println(", " + fn);
            }
        } else {
            fn = 1;
        }
        return fn;
    }

    public static void Josehp(int n, int m, int k) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        int count = 0;
        int number = n;
        while (number > 1) {
            for (int i = 0; i < n; i++) {
                if (m != 1) {
                    i = m - 1;
                    m = 1;
                }
                if (array[i] == 0)
                    continue;
                count++;
                if (count == k) {
                    array[i] = 0;
                    count = 0;
                    number--;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print((array[i] + 1) + " ");
        }
        System.out.println();
    }

    public static void j(int totalNum, int countNum) {
        List<Integer> start = new ArrayList<Integer>();
        for (int i = 1; i <= totalNum; i++) {
            start.add(i);

        }
        //从第K个开始计数
        int k = 0;
        while (start.size() > 0) {
            k = k + countNum;
            //第m人的索引位置
            k = k % (start.size()) - 1;
            // 判断是否到队尾
            if (k < 0) {
                System.out.println(start.get(start.size() - 1));
                start.remove(start.size() - 1);
                k = 0;

            } else {
                System.out.print(start.get(k) + " ");
                start.remove(k);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] n = new int[T];

        for (int i = 0; i < T; i++) {
            n[i] = scanner.nextInt();
            j(n[i], 2);
        }
    }
}
