package com.agenthun.schoolrecruit2016;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by agenthun on 16/7/23.
 */
public class RussianDoll {
    class Doll {
        int weight;
        int height;

        public Doll(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int hight) {
            this.height = height;
        }
    }

    class DollComparator implements Comparator<Doll> {

        @Override
        public int compare(Doll o1, Doll o2) {
            if (o1.weight == o2.weight) {
                if (o1.height == o2.height) {
                    return 0;
                } else if (o1.height < o2.height) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (o1.weight < o2.weight) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    int maxDoll(int[][] a) {
        if (a == null || a.length == 0 || a[0] == null || a[0].length != 2) {
            return 0;
        }

        Doll[] dolls = new Doll[a.length];
        for (int i = 0; i < a.length; i++) {
            dolls[i] = new Doll(a[i][0], a[i][1]);
        }

        Arrays.sort(dolls, new DollComparator());
        int[] ends = new int[a.length];
        ends[0] = dolls[0].height;

        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;

        for (int i = 1; i < dolls.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (dolls[i].height > ends[m]) {
                    l = m + 1;
                } else {

                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[l] = dolls[i].height;
        }
        return right + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[][] a = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = scanner.nextInt();
                a[i][1] = scanner.nextInt();
            }
            int max = new RussianDoll().maxDoll(a);
            System.out.println(max);
        }
    }
}
