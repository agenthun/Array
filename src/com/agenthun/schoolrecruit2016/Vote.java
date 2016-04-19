package com.agenthun.schoolrecruit2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by agenthun on 16/4/8.
 * 小东和其他小朋友正在玩一个关于选举的游戏。选举是通过投票的方式进行的，得票最多的人将获胜。
 * 小东是编号为1的候选者，此外还有其他的候选者参加选举。根据初步的调查情况，所有准备投票的小朋友都有一定的投票倾向性，小东如果要获得胜利，必须争取部分准备为其他候选人投票的小朋友。
 * 由于小东的资源较为有限，她希望用最小的代价赢得胜利，请你帮忙计算她最少需要争取的选票数。
 * 输入
 * 输入有若干组，每组包含两行，第一行为一个正整数n（2<=n<=100），表示候选者的数量，
 * 第二行为每个候选人预期得到的选票数，以空格分开，每人的预期得票数在1到1000之间（包含1和1000）。
 * 经过小东的争取后，可能出现候选人得票数为0或超过1000的情况。
 * 输出
 * 对每组测试数据，单独输出一行，内容为小东最少需要争取的选票数。
 * 样例输入
 * 5
 * 5 1 11 2 8
 * 4
 * 1 8 8 8
 * 2
 * 7 6
 * 样例输出
 * 4
 * 6
 * 0​
 */
public class Vote {
    private static int get(int[] person, int n) {
        int count = 0;
        Arrays.sort(person, 1, n);
        List<Integer> list = new ArrayList<>();
        list = new LinkedList<>();

        for (int i = n - 1; i > 0; i--) {
            while (i != 1 && (person[i] >= person[i - 1]) && (person[0] <= person[i])) {
                if (person[i] > 0) {
                    person[i] -= 1;
                    person[0] += 1;
                    count++;
                } else {
                    break;
                }
            }
            if ((i == 1) && (person[0] <= person[i])) {
                if (person[i] > 0) {
                    person[i] -= 1;
                    person[0] += 1;
                    count++;
                } else {
                    i = n;
                    break;
                }
                if (person[0] <= person[i] && person[i] >= 0)
                    i = n;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) break;

            int[] person = new int[n];
            for (int i = 0; i < n; i++) {
                person[i] = scanner.nextInt();
            }
            int res = get(person, n);
            System.out.println(res);
        }
    }
}
