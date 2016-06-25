package com.agenthun.schoolrecruit2016;

import java.util.*;

/**
 * Created by agenthun on 16/6/25.
 * 经过深思熟虑之后，小贱君打算去M国闯一闯，那是一个古老的东方国度，传说有很多高阶魔法师，他想成为一名伟大的魔法师，将来征服星辰大海。
 * 经过千辛万苦，小贱君终于来到了M国，不幸的是刚进城门小贱君就被M国的守城士兵困在了一种叫做“困兽之斗”的阵法之中。
 * 士兵对小贱君说：“看到漂浮在你身边的宝石了吗？彩虹连接的两颗宝石可以任意交换位置，你需要通过一系列交换后使得宝石组成的字符串的字典序最小。若不能破阵，那还是请回吧！”
 * 小贱君观察了一下周围的宝石，只见每颗宝石上标有一个小写字母，而且有一些宝石上通过彩虹与其他宝石相连。
 * 琢磨了半天，他终于搞懂了这个阵法的意思：
 * 若宝石系列为：dcba
 * 其中有两道彩虹，分别是(0,1),(1,2),代表第一个位置上的宝石可以和第二个位置上的宝石互换，第二个位置上的宝石可以和第三个位置上的宝石互换，最终可以得到字典序最小的宝石系列：bcda。
 * 作为小贱君的死党，你有什么方法帮助他破阵吗？
 * 输入描述:
 * 输入包含多组测试数据。
 * 对于每组测试数据：
 * 字符串s --- 代表宝石序列
 * n --- 代表有n条彩虹
 * 接下来n行，每行两个数ai,bi --- 表示ai和bi由一条彩虹相连。
 * 保证：
 * 1<=s的长度<=10000
 * 1<=n<=10000
 * 且输入数据均合法。
 * 输出描述:
 * 对于每组数据，输出一个字符串
 * 输入例子:
 * dcba
 * 2
 * 0 1
 * 1 2
 * hellonowcoder
 * 4
 * 0 1
 * 1 4
 * 2 5
 * 2 3
 * 输出例子:
 * bcda
 * ehllonowcoder
 */
public class WarcraftArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            Map<Integer, Integer> maps = new HashMap<>();
            String s = in.next();
            char[] chars = s.toCharArray();//字符串数组
            int n = in.nextInt();//找出几组可交换的
            for (int i = 0; i < n; i++) {
                maps.put(in.nextInt(), in.nextInt());
            }
            //开始寻找排序链
            for (Map.Entry<Integer, Integer> entry : maps.entrySet()) {
                int i = entry.getKey();
                ArrayList<Integer> list = new ArrayList<>();
                while (maps.containsKey(i)) {
                    if (!list.contains(i))
                        list.add(i);
                    list.add(maps.get(i));
                    i = maps.get(i);
                }
                maps.remove(i);
                if (!list.isEmpty()) {
                    sort(chars, list);//对chars排序，下标集合是list
                }

            }
            System.out.println(new String(chars));
        }
    }

    public static void sort(char[] chars, ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (chars[list.get(j)] > chars[list.get(j + 1)]) {
                    char tmp = chars[list.get(j)];
                    chars[list.get(j)] = chars[list.get(j + 1)];
                    chars[list.get(j + 1)] = tmp;
                }
            }
        }
    }
/*    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int n = Integer.valueOf(scanner.nextLine().split(" ")[0]);
            int[][] a = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] tt = scanner.nextLine().split(" ");
                a[i][0] = Integer.valueOf(tt[0]);
                a[i][1] = Integer.valueOf(tt[0]);
            }


            char[] c = str.toCharArray();
            TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });
            for (int i = 0; i < n; i++) {
                map.put(a[i][1], i);
            }

            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                int index = map.get(iterator.next());
                if (c[a[index][0]] > c[a[index][1]]) {
                    char temp = c[a[index][0]];
                    c[a[index][0]] = c[a[index][1]];
                    c[a[index][1]] = temp;
                }
            }

            System.out.println(String.valueOf(c));
        }
    }*/
}
