package com.agenthun.schoolrecruit2016;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by agenthun on 16/8/1.
 * Kaprekar数字黑洞
 * 6767
 * 7766 - 6677 = 1089
 * 9810 - 189 = 9621
 * 9621 - 1269 = 8352
 * 8532 - 2358 = 6174
 */
public class Kaprekar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();

            Character[] a = new Character[str.length()];
            for (int i = 0; i < str.length(); i++) {
                a[i] = str.charAt(i);
            }

            kaprekar(a);
        }
    }

    private static void kaprekar(Character[] a) {
        if (a[0].equals('6') && a[1].equals('1') && a[2].equals('7') && a[3].equals('4')) {
            return;
        }

        Character[] b = a.clone();

        Arrays.sort(b, new Comparator<Character>() {

            @Override
            public int compare(Character o1, Character o2) {
                return o1.compareTo(o2);
            }
        });

        Arrays.sort(a, new Comparator<Character>() {

            @Override
            public int compare(Character o1, Character o2) {
                return o2.compareTo(o1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
        }
        int x = Integer.parseInt(sb.toString());

        sb = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            sb.append(b[i]);
        }
        int y = Integer.parseInt(sb.toString());

        int z = x - y;
        System.out.println(x + " - " + y + " = " + z);

        char[] charZ = String.format("%04d", z).toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = charZ[i];
        }

        kaprekar(a);
    }
}
