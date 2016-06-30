package com.agenthun.schoolrecruit2016;

import java.util.ArrayList;

/**
 * Created by agenthun on 16/7/1.
 * 对于传统的汉诺塔游戏我们做一个拓展，我们有从大到小放置的n个圆盘，开始时所有圆盘都放在左边的柱子上，
 * 按照汉诺塔游戏的要求我们要把所有的圆盘都移到右边的柱子上，请实现一个函数打印最优移动轨迹。
 * 给定一个int n，表示有n个圆盘。请返回一个string数组，其中的元素依次为每次移动的描述。描述格式为：
 * move from [left/mid/right] to [left/mid/right]。
 * 测试样例：
 * 1
 * 返回：move from left to right
 */
public class Hanoi {
    public static ArrayList<String> getSolution(int n) {
        // write code here
        ArrayList<String> res = new ArrayList<>();
        move(n, "left", "mid", "right", res);
        return res;
    }

    public static void move(int n, String left, String mid, String right, ArrayList<String> res) {
        if (n == 1) res.add("move from " + left + " to " + right);
        else {
            move(n - 1, left, right, mid, res);
            res.add("move from " + left + " to " + right);
            move(n - 1, mid, left, right, res);
        }
    }


    public static void main(String[] args) {
        int n = 3;
        ArrayList<String> arrayList = getSolution(n);
        for (String str :
                arrayList) {
            System.out.println(str);
        }
    }
}
