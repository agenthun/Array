package com.agenthun.schoolrecruit2016;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by agenthun on 16/8/1.
 * n长度数组,取k个,两两之间位置不超过d,求着k个最大的元素乘积
 * input: n; 数组a; k个; 间隔d
 * 3
 * 7 4 7
 * 2 50
 * output:
 * 49
 */
public class MaxPowerMux {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            int k = scanner.nextInt();
            int d = scanner.nextInt();

            double s0 = 1;
            Map<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < k; i++) {
                if (!map.containsKey(a[i])) {
                    map.put(a[i], i);
                } else {
                    if (i > map.get(a[i])) {
                        map.put(a[i], i);
                    }
                }
                s0 = s0 * a[i];
            }

            for (int i = k; i < a.length; i++) {
                Iterator iter = map.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    int key = (Integer) entry.getKey();
                    int val = (Integer) entry.getValue();

                    if (val != -1 && a[i] > key && (i - val) <= d) {
                        s0 = s0 * a[i] / key;
                        map.remove(key);
                        if (map.containsKey(a[i])) {
                            if (i > map.get(a[i])) {
                                map.put(a[i], i);
                            }
                        } else {
                            map.put(a[i], i);
                        }
                        break;
                    }
                }
            }
            System.out.println((int) s0);
        }
    }
}
