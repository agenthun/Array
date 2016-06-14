package com.agenthun.schoolrecruit2016;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by agenthun on 16/6/14.
 */
public class Main {
    public static int getResult(int n, String[] strNum) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < strNum[0].length(); i++) {
            set.add(strNum[0].charAt(i));
            for (int j = 0; j < strNum[1].length(); j++) {
                set.add(strNum[1].charAt(j));
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String[] strNum = scanner.nextLine().split(" ");
            System.out.println(getResult(n, strNum));
        }
    }
}
