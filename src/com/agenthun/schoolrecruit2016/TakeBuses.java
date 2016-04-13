package com.agenthun.schoolrecruit2016;

/**
 * Created by agenthun on 16/4/13.
 * 从小明家所在公交站出发有n路公交到公司，现给出每路公交的停站数(不包括起点和终点)，
 * 及每次停的时间(一路车在每个站停的时间相同)和发车的间隔，
 * 先假定每辆车同时在相对时间0分开始发车，且所有车在相邻两个站之间的耗时相同,都为5分钟。
 * 给定小明起床的相对时间(相对0的分钟数)，请计算他最早到达公司的相对时间。
 * 给定每路车的停站数stops,停站时间period,发车间隔interval及公交路数n，出发时间s。
 * 请返回最早到达时间。保证公交路数小于等于500，停站数小于等于50。
 * input:[13,15,26,7,27,3,30],[1,2,1,2,2,2,1],[5,1,4,3,2,1,4],7,10
 * output:36
 */
public class TakeBuses {
    public int chooseLine(int[] stops, int[] period, int[] interval, int n, int s) {
        // write code here
        int time = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int k = 0;
            while (interval[i] * k < s) k++;
            int temp = stops[i] * (period[i] + 5) + 5 + interval[i] * k;
            if (temp < time) time = temp;
        }
        return time;
    }

    public static void main(String[] args) {
        int[] stops = {13, 15, 26, 7, 27, 3, 30};
        int[] period = {1, 2, 1, 2, 2, 2, 1};
        int[] interval = {5, 1, 4, 3, 2, 1, 4};
        int n = 7;
        int s = 10;
        int res = new TakeBuses().chooseLine(stops, period, interval, n, s);
        System.out.println("res = " + res);
    }
}
