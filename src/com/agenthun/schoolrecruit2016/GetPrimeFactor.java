package com.agenthun.schoolrecruit2016;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by agenthun on 16/6/13.
 */
public class GetPrimeFactor {
    public static String getResult(long ulDataInput) {
        int n = 2;
        LinkedList<Long> list = new LinkedList<>();

        while (n * n <= ulDataInput) {
            while (ulDataInput % n == 0) {
                list.add((long) n);
                ulDataInput /= n;
            }
            n++;
        }
        if (ulDataInput > 1) list.add(ulDataInput);
        Collections.sort(list);

        StringBuilder builder = new StringBuilder();
        for (Long temp :
                list) {
            builder.append(temp + " ");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long data = scanner.nextLong();
            System.out.println(getResult(data));
        }
    }
}
