package com.agenthun.schoolrecruit2016;

/**
 * Created by agenthun on 16/3/28.
 * 现在有一个城市销售经理，需要从公司出发，去拜访市内的商家，已知他的位置以及商家的位置，但是由于城市道路交通的原因，
 * 他只能在左右中选择一个方向，在上下中选择一个方向，现在问他有多少种方案到达商家地址。
 * 给定一个地图map及它的长宽n和m，其中1代表经理位置，2代表商家位置，-1代表不能经过的地区，0代表可以经过的地区，请返回方案数，
 * 保证一定存在合法路径。保证矩阵的长宽都小于等于10。
 * 测试样例：[[0,1,0],[2,0,0]],2,3
 * 返回：2
 */
public class Visit {
    public int countPath(int[][] map, int n, int m) {
        // write code here
        if (map == null || map.length == 0) return 0;

        int x1 = -1, y1 = -1, x2 = -1, y2 = -1;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    x1 = i;
                    y1 = j;
                    if (x2 != -1)
                        break;
                }
                if (map[i][j] == 2) {
                    x2 = i;
                    y2 = j;
                    if (x1 != -1)
                        break;
                }
            }
        }
        int xs = x1 < x2 ? 1 : (-1);
        int ys = y1 < y2 ? 1 : (-1);
        for (int j = y1; j != y2 + ys; j = j + ys) {
            map[x1][j] = j == y1 ? 1 : (map[x1][j] == -1 ? 0 : (map[x1][j - ys]));
            for (int i = x1 + xs; i != x2 + xs; i = i + xs) {
                if (j == y1) {
                    map[i][j] = map[i][j] == -1 ? 0 : (map[i - xs][j]);
                } else {
                    map[i][j] = map[i][j] == -1 ? 0 : (map[i - xs][j] + map[i][j - ys]);
                }
            }
        }
        return map[x2][y2];
    }
}
