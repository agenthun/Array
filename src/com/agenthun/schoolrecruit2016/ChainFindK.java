package com.agenthun.schoolrecruit2016;

/**
 * Created by agenthun on 16/4/24.
 * 现在A和B在玩一个游戏，这个游戏首先给了他们很多珠子，珠子有两种颜色，一种蓝色，一种黄色，我们假定两种珠子都有无限多。
 * A需要选择n颗珠子(n为奇数)，然后由B串成一串项链(顺序由B确定,这里的项链也就是一个环)。
 * 假如在最后串成的项链中，A能够找到两个不同位置的蓝色珠子，并在这两处把这个项链断开成两段，其中一段恰好长度为(n+1)/2那么A就胜利了，注意这里为整数截断除法且这个长度是不包括选出的两颗珠子的。
 * 现在请你计算出A至少要选择多少颗蓝色珠子，才能保证无论B怎么串，他都能获胜。举个例子，当A选了7颗珠子，其中有3颗蓝珠子，那么如果B串的项链为"蓝蓝红红红红蓝"，则A能获胜，若B串的项链为"蓝蓝红红蓝红红"，则A不能获胜。
 * 输入描述:给定一个整数n，为A要选出的珠子颗数.
 * 输出描述:请返回A至少要选的蓝珠子颗数。
 * 输入例子:
 * 7
 * 输出例子:
 * 4
 */
public class ChainFindK {
    public int findK(int n) {
        // write code here
        if (n % 3 == 0)
            n = (n - 1) >> 1;
        else
            n = (n + 1) >> 1;
        return n;
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.println("findK(n) = " + new ChainFindK().findK(n));
    }
}
