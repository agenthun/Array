package com.agenthun.schoolrecruit2016;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by agenthun on 16/8/1.
 * 下厨房
 * 一个测试用例,第i行需要一些材料,以空格大写英文字母区分,求需要几种材料
 * input:
 * BUTTER FLOUR
 * HONEY FLOUR ECG
 * output:
 * 4
 */
public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;
        while (scanner.hasNext()) {
            String[] str = scanner.nextLine().trim().split(" ");
            for (String m :
                    str) {
                if (!map.containsKey(m)) {
                    map.put(m, 1);
                }
            }
            count++;
            if (count > 50) {
                break;
            }
        }
        System.out.println(map.size());
    }
}
