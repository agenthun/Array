package com.agenthun.leetcode;

/**
 * Created by agenthun on 16/1/5.
 */
public class CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");

        int i = 0;
        while (i < a1.length || i < a2.length) {
            if (i < a1.length && i < a2.length) {
                if (Integer.parseInt(a1[i]) < Integer.parseInt(a2[i])) {
                    return -1;
                } else if (Integer.parseInt(a1[i]) > Integer.parseInt(a2[i])) {
                    return 1;
                }
            } else if (i < a1.length) {
                if (Integer.parseInt(a1[i]) != 0) {
                    return 1;
                }
            } else if (i < a2.length) {
                if (Integer.parseInt(a2[i]) != 0) {
                    return -1;
                }
            }
            i++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String v1 = "1.1";
        String v2 = "1.2";
        System.out.println("v1 = " + v1);
        System.out.println("v2 = " + v2);
        System.out.println("compareVersion(v1,v2) = " + compareVersion(v1, v2));
    }
}
