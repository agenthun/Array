package com.agenthun.schoolrecruit2016;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by agenthun on 16/7/30.
 * 最近有一种简单的扑克牌游戏特别流行，作为时尚潮流的风向标，小B也对这种游戏颇有兴趣。
 * 游戏采用计分制，规则非常简单，游戏过程中每个玩家会得到或失去一些分值，游戏结束时根据玩家的得分确定胜者。根据游戏规则，可能存在所有玩家都失分的情况，即不保证游戏结束时一定有得到正分的玩家出现。每次玩家得分的情况以”name score”的形式记录在单独的一行中，其中“name”为玩家的名字，”score”则为玩家的得分值，为一个整数。若score为负数，表示此次游戏中玩家失分了。
 * 若游戏结束时只有一个玩家的分值最多，则该玩家获胜。若有多个玩家在游戏结束时得到的分值相同且均为最多，此时确定获胜的玩家会变得麻烦。根据大家都接受的约定规则，多人在游戏结束时均得到最高分时，最先拿到最高分的玩家获胜。
 * 输入
 * 输入的第一行为一个正整数T，表示有T组测试数据。每组测试数据的第一行为一个正整数n（1<=n<=1000），表示该组中游戏得分的记录数，紧随其后有n行数据，每行的格式均为”name score”形式，按游戏进行的时间排序。其中name由最多不超过32个小写字母构成，score为-1000到1000之间的整数。
 * 输出
 * 对每组测试数据，在单独的一行里输出获胜玩家的名字。
 * <p>
 * <p>
 * 样例输入
 * 2
 * 3
 * mike 3
 * andrew 5
 * mike 2
 * 3
 * andrew 3
 * andrew 2
 * mike 5
 * 0000pt;" >
 * 样例输出
 * andrew
 * andrew
 */
public class PokerWinner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T > 0 && scanner.hasNext()) {
            HashMap<String, Integer> map = new HashMap<>();
            int n = scanner.nextInt();
            int maxScore = Integer.MIN_VALUE;
            String maxScoreOwner = null;
            for (int i = 0; i < n; i++) {
                String name = scanner.next();
                int score = scanner.nextInt();
                if (!map.containsKey(name)) {
                    map.put(name, score);
                    if (map.get(name) > maxScore) {
                        maxScoreOwner = name;
                        maxScore = map.get(name);
                    }
                } else {
                    map.put(name, map.get(name) + score);
                    if (map.get(name) > maxScore) {
                        maxScoreOwner = name;
                        maxScore = map.get(name);
                    }
                }
            }

            Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                String name = (String) entry.getKey();
                int score = (Integer) entry.getValue();


                if (maxScoreOwner.equals(name) && score == maxScore) {
                    System.out.println(name);
                    break;
                }
            }

            T--;
        }
    }
}
