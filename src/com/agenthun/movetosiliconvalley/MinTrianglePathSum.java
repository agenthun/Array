package com.agenthun.movetosiliconvalley;

import java.util.ArrayList;

/**
 * Created by agenthun on 15/10/2.
 */
public class MinTrianglePathSum {
    int minTrianglePathSum(ArrayList<ArrayList<Integer>> triangle) {
        ArrayList<Integer> path = new ArrayList<>();
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (i == triangle.size() - 1) {
                    path.add(triangle.get(i).get(j));
                } else {
                    path.set(j, Math.min(path.get(j), path.get(j + 1)) + triangle.get(i).get(j));
                }
            }
        }
        return path.get(0);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> tris = new ArrayList<>();
        ArrayList<Integer> tri = new ArrayList<>();
        tri.add(2);
        tris.add(tri);

        tri = new ArrayList<>();
        tri.add(3);
        tri.add(4);
        tris.add(tri);

        tri = new ArrayList<>();
        tri.add(6);
        tri.add(5);
        tri.add(7);
        tris.add(tri);

        tri = new ArrayList<>();
        tri.add(8);
        tri.add(3);
        tri.add(9);
        tri.add(2);
        tris.add(tri);

        for (int i = 0; i < tris.size(); i++) {
            for (int j = 0; j < tris.get(i).size(); j++) {
                System.out.print(tris.get(i).get(j) + " ");
            }
            System.out.println();
        }

        System.out.println("minTrianglePathSum(tris) = " + new MinTrianglePathSum().minTrianglePathSum(tris));
    }
}
