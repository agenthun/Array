package com.agenthun.schoolrecruit2016;

import java.util.*;

/**
 * Created by agenthun on 16/8/28.
 * 爬山
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 小B曾经酷爱网络游戏，整日通宵达旦的玩游戏，
 * 导致身体素质急剧下降，因此下决心痛改前非，远离一切电子产品，并通过远足爬山的方式改变生活方式并提高身体素质。
 * 由于担心对身体造成太大的负荷，他总是选择最平坦的路径，并记录每天的行程情况及达到的最高海拔，使得连续两天之间的海拔之差最多为一个单位。
 * 不幸的是，在行程结束时，他不小心掉进河里，造成部分记录信息遗失。
 * 他想知道自己行程中可能达到的最高海拔，你是否能够帮忙？
 * 输入
 * 输入有若干组，每组的第一行为空格分隔的两个整数n和m，1<=n<=10^8, 1<=m<=10^5，分别表示行程天数以及未遗失的记录数。
 * 随后紧跟m行，每行为空格分隔的两个整数d和h，1<=d<=n, 0<=h<=10^8，表示行程的第几天及当天达到的最高海拔。
 * 输出
 * 对每组输入，如果记录是可能的，则在单独的行中输出可能达到的最高海拔，否则输出字符串“IMPOSSIBLE”（不含引号）。
 * <p>
 * 样例输入
 * 8 2
 * 2 0
 * 7 0
 * 8 3
 * 2 0
 * 7 0
 * 8 3
 * 样例输出
 * 2
 * IMPOSSIBLE
 * <p>
 * Hint
 * 第一天和最后一天的海拔可以是任何值。
 */
public class ClimbMount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] x = new int[n];
            for (int i = 0; i < x.length; i++) {
                x[i] = -1;
            }

            int[] d = new int[m];
            int[] h = new int[m];
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < m; i++) {
                d[i] = scanner.nextInt();
                h[i] = scanner.nextInt();
                x[d[i] - 1] = h[i];
                if (!map.containsKey(d[i] - 1)) {
                    map.put(d[i] - 1, h[i]);
                }
            }

            int index = 0;
            int height = -1;
            int res = -1;

            Iterator iter = map.entrySet().iterator();
            Map.Entry entry = (Map.Entry) iter.next();
            index = (int) entry.getKey();
            height = (int) entry.getValue();

            while (iter.hasNext()) {
                int index2 = (int) entry.getKey();
                int height2 = (int) entry.getValue();
                int dis = index2 - index;
                if (height2 > height) {
                    if ((height2 - height) > dis) {
                        res = -1;
                        break;
                    } else {
                        res = Math.max(res, height2);
                    }
                } else if (height2 < height) {
                    if ((height - height2) > dis) {
                        res = -1;
                        break;
                    } else {
                        res = Math.max(res, height);
                    }
                } else {
                    res = Math.max(res, height + dis / 2);
                }
                index = index2;
                height = height2;
            }

//            for (int i = 0; i < x.length; i++) {
//                if (x[i] != -1 && height == -1) {
//                    index = i;
//                    height = x[i];
//                } else if (x[i] != -1 && height != -1) {
//                    int dis = i - index;
//                    if (x[i] > height) {
//                        if ((x[i] - height) > dis) {
//                            res = -1;
//                            break;
//                        } else {
//                            res = Math.max(res, x[i]);
//                        }
//                    } else if (x[i] < height) {
//                        if ((height - x[i]) > dis) {
//                            res = -1;
//                            break;
//                        } else {
//                            res = Math.max(res, height);
//                        }
//                    } else {
//                        res = Math.max(res, height + dis / 2);
//                    }
//                    index = i;
//                    height = x[i];
//                }
//            }

//            int i = 1;
//            if (x[0] == -1) {
//                while (x[i] == -1) {
//                    i++;
//                }
//                res = Math.max(res, x[i] + i);
//            }
//
//            i = x.length - 2;
//            if (x[x.length - 1] == -1) {
//                while (x[i] == -1) {
//                    i--;
//                }
//                res = Math.max(res, x[i] + x.length - i);
//            }

            if (res == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(res);
            }
        }
    }
}
