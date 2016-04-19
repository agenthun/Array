package com.agenthun.schoolrecruit2016;

/**
 * Created by agenthun on 16/4/19.
 */
public class Partition {
    public int[] getPartition(int[][] land, int n, int m) {
        // write code here
        int[] result = new int[2];

        int res = Integer.MAX_VALUE;
        for (int part = 0; part <= n; part++) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (land[i][j] == 1 && j < part) count++;
                    if (land[i][j] == 0 && j >= part) count++;
                }
            }
            if (count < res) {
                res = count;
                result[0] = part;
            }
        }
        result[1] = result[0] + 1;
        return result;
    }

    public static void main(String[] args) {
        int[][] land = {
                {1, 1, 1, 1},
                {0, 0, 0, 0},
                {1, 0, 1, 1}
        };
        int n = 4, m = 3;
        int[] res = new Partition().getPartition(land, n, m);
        System.out.println("res = " + res[0]);
    }
}
