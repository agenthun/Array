package com.agenthun.schoolrecruit2016;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by agenthun on 16/6/14.
 * 卢卡斯的驱逐者大军已经来到了赫柏的卡诺萨城，赫柏终于下定决心,集结了大军,与驱逐者全面开战。
 * 卢卡斯的手下有6名天之驱逐者，这6名天之驱逐者各赋异能，是卢卡斯的主力。
 * 为了击败卢卡斯，赫柏必须好好考虑如何安排自己的狂战士前去迎战。
 * 狂战士的魔法与一些天之驱逐者的魔法属性是相克的，第i名狂战士的魔法可以克制的天之驱逐者的集合为Si(Si中的每个元素属于[0,5])。
 * 为了公平，两名狂战士不能攻击同一个天之驱逐者。
 * 现在赫柏需要知道共有多少种分派方案。
 * 例：
 * S1={01},S2={23}，代表编号为0的狂战士的魔法可以克制编号为0和编号为1的天之驱逐者，编号为1的狂战士的魔法可以克制编号为2和编号为3的天之驱逐者，共有四种方案：02,03,12,13。
 * 02---代表第一个狂战士负责编号为0的驱逐者，第二个狂战士负责编号为2的驱逐者；
 * 03---代表第一个狂战士负责编号为0的驱逐者，第二个狂战士负责编号为3的驱逐者；
 * 12---代表第一个狂战士负责编号为1的驱逐者，第二个狂战士负责编号为2的驱逐者;
 * 13---代表第一个狂战士负责编号为1的驱逐者，第二个狂战士负责编号为3的驱逐者;
 * S1={01},S2={01}，代表编号为0的狂战士的魔法可以克制编号为0和编号为1的天之驱逐者，编号为1的狂战士的魔法可以克制编号为0和编号为1的天之驱逐者，共有两种方案：01,10。
 * 输入描述:
 * 多组测试数据，请处理到文件结束。
 * 对于每组测试数据：
 * 第一行为一个整数N，代表狂战士的数量。
 * 第二行为N个字符串，第i个字符串表示第i个狂战士能够克制的天之驱逐者的集合。
 * 保证：
 * 1<=N<=6，1<=每个字符串的长度<=6，且每个字符都是0~5中的一个数字。
 * 输出描述:
 * 输出一个整数，代表分配方案数
 * 输入例子:
 * 2
 * 01 23
 * 2
 * 01 01
 * 3
 * 3 015 5
 * 输出例子:
 * 4
 * 2
 * 2
 */
public class WarcraftFight {

    static int count = 0;

    public static void permutation(String[] strNum, int target, HashSet<Character> set) {
        if (target == strNum.length) {
            count++;
            return;
        } else {
            String str = strNum[target];
            for (int i = 0; i < str.length(); i++) {
                if (!set.contains(str.charAt(i))) {
                    set.add(str.charAt(i));
                    permutation(strNum, target + 1, set);
                    set.remove(str.charAt(i));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.valueOf(scanner.nextLine().split(" ")[0]);
            String[] strNum = scanner.nextLine().split(" ");
            HashSet<Character> set = new HashSet<>();
            count = 0;
            permutation(strNum, 0, set);
            System.out.println(count);
        }
    }
}
