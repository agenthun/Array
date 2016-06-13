package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/6/13.
 */
public class GetSameChar {
    public static int getResult(String str, char c) {
        int len = 0;

        str = str.toLowerCase();

        if (c >= 'A' && c <= 'Z') {
            c = (char) (c - 'A' + 'a');
        }
        for (int i = 0; i < str.length(); i++) {
            if (c == str.charAt(i)) {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char c = scanner.next().charAt(0);
            System.out.println(getResult(str, c));
        }
    }
}
