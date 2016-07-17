package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/7/17.
 * The numberic keypad on your mobile phone looks like below:
 * 123
 * 456
 * 789
 * *0*
 * suppose you are holding your mobile phone with single hand. Your thumb points at digit 1. Each time you can 1)press the digit your thumb pointing at.2)moveyour thumb right,3)move your thumb down. Moving your thumb left or up is not allowed.
 * By using the numeric keypad under above constrains, you can produce some numbers like 177 or 480 while producing other numbers like 590 or 52 is impossible.
 * Given a number K, find out the maximum number less than or equal to K that can be produced.
 * <p>
 * 输入描述:
 * the first line contains an integer T, the number of testcases.
 * Each testcase occupies a single line with an integer K.
 * <p>
 * For 50%of the data ,1<=K<=999.
 * For 100% of the data, 1<=K<=10^500,t<=20.
 * <p>
 * 输出描述:
 * for each testcase output one line, the maximum number less than or equal to the corresponding K that can be produced.
 * <p>
 * 输入例子:
 * 3
 * 25
 * 83
 * 131
 * <p>
 * 输出例子:
 * 25
 * 80
 * 129
 */
public class NumericKeypad {
    public static final int[][] pad = {
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 1, 0, 1, 1, 0, 1, 1},
            {0, 0, 0, 1, 0, 0, 1, 0, 0, 1},
            {1, 0, 0, 0, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 1, 1, 0, 1, 1},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            int[] K = new int[T];
            for (int i = 0; i < T; i++) {
                K[i] = scanner.nextInt();
                String k = String.valueOf(K[i]);

                int n = k.length();
                boolean flag = true;
                int j = 0;
                for (; j < n - 1; j++) {
                    if (pad[k.charAt(j) - '0'][k.charAt(j + 1) - '0'] == 0) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    System.out.println(k);
                    continue;
                }

                int index = k.charAt(j + 1) - '0' - 1;
                for (; index >= 0; index--) {
                    if (pad[k.charAt(j) - '0'][index] == 1) {
                        break;
                    }
                }

                StringBuilder s = new StringBuilder(k);
                if (index == -1) {
                    int l = j;
                    for (; l >= 1; l--) {
                        if (s.charAt(l) != s.charAt(l - 1) && (s.charAt(l) - s.charAt(l - 1) % 3 == 0)) {
                            s.setCharAt(l, (char) (s.charAt(l) -3));
                            break;
                        } else if (s.charAt(l) != s.charAt(l - 1) && (s.charAt(l) - s.charAt(l - 1) % 3 != 0)) {
                            s.setCharAt(l, (char) (s.charAt(l) - 1));
                            break;
                        }
                    }

                    if (l == 0) {
                        s.setCharAt(l, (char) (s.charAt(l) - 1));
                    }
                    for (l++; l < n; l++) {
                        s.setCharAt(l, '9');
                    }
                } else {
                    s.setCharAt(j + 1, (char) (index + '0'));
                    if (index == 0) {
                        for (index = j + 2; index < n; index++) {
                            s.setCharAt(index, '0');
                        }
                    } else {
                        for (index = j + 2; index < n; index++) {
                            s.setCharAt(index, '9');
                        }
                    }
                }

                System.out.println(s);
            }
        }
    }
}
