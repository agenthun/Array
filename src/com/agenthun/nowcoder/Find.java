package com.agenthun.nowcoder;

/**
 * Created by agenthun on 16/1/27.
 */
public class Find {
    public static boolean Find(int[][] array, int target) {
        if (array == null || array.length == 0) return false;
        boolean result = false;

        int left = 0;
        int right = array[0].length - 1;

        while ((left < array.length) && right >= 0) {
            if (array[left][right] < target) {
                left++;
            } else if (array[left][right] > target) {
                right--;
            } else {
                return true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {6, 7, 8, 9}
        };

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        int target = 10;
        System.out.println("target = " + target);

        System.out.println("Find(array,target) = " + Find(array, target));
    }
}
