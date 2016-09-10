package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/9/9.
 * 第K个字典序
 * 4位：a~y 25个字母
 * a,aa,aaa,aaaa,aaab,....b,ba,baa,baaa,....
 * 求aaac是第几个字典数
 */
public class PermDictionaryK {
    public static void perm(char[] buf, int start, int end) {
        if (start == end) {
            for (int i = 0; i <= end; i++) {
                System.out.print(buf[i]);
            }
            System.out.println();
        } else {
            for (int i = start; i <= end; i++) {
                char temp = buf[start];
                buf[start] = buf[i];
                buf[i] = temp;
                perm(buf, start + 1, end);

                temp = buf[start];
                buf[start] = buf[i];
                buf[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();

            char[] chars = s.toCharArray();
//            int count = 0;
//            int temp = chars[0] - 'a';
//            count += temp * 3;
//
//            for (int i = 1; i < chars.length; i++) {
//
//            }

            perm(chars, 0, chars.length - 1);
        }
    }
}
