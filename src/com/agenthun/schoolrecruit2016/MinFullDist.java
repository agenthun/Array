package com.agenthun.schoolrecruit2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by agenthun on 16/9/9.
 * 遍历最短路径长度
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 暴风降临的龙母丹妮莉丝·坦格利安要骑着她的龙以最快的速度游历各国，她的谋士们纷纷献策规划路线。
 * 作为她的谋士之一和仰慕者的你，决定冒险穿越到21世纪借助计算机来寻求最优路线。
 * 请设计一段程序，读取各国两两之间的距离，距离以邻接矩阵表示，并计算出遍历各国的最短路径长度。
 * 输入
 * 第一行：国家数量，假设为n
 * 后续n行是国家间距离的邻接矩阵表示
 * 输出
 * 遍历各国的最短路径长度
 * <p>
 * 样例输入
 * 4
 * 0,1,2,3
 * 1,0,4,5
 * 2,4,0,2
 * 3,5,2,0
 * 样例输出
 * 5
 */
public class MinFullDist {

    public static void permute(int[] nums, int[][] map) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        int[] dist = new int[1];
        dist[0] = Integer.MAX_VALUE;
        helper(nums, new ArrayList<Integer>(), used, map, dist);
        System.out.println(dist[0]);
    }

    private static void helper(int[] nums, List<Integer> sub, boolean[] used, int[][] map, int[] dist) {
        if (sub.size() == nums.length) {
            int temp = 0;
            for (int i = 0; i < sub.size() - 1; i++) {
                temp += map[sub.get(i)][sub.get(i + 1)];
            }
            if (temp < dist[0]) {
                dist[0] = temp;
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            sub.add(nums[i]);
            used[i] = true;
            helper(nums, sub, used, map, dist);
            sub.remove(sub.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] map = new int[n][n];
            for (int i = 0; i < map.length; i++) {
                String[] str = scanner.nextLine().split(",");
                if (str.length == 4) {
                    for (int j = 0; j < str.length; j++) {
                        map[i][j] = Integer.parseInt(str[j]);
                    }
                }
            }

            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = i;
            }
            permute(array, map);
        }
    }
}
