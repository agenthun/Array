package com.agenthun.schoolrecruit2016;

import java.io.*;
import java.util.Scanner;

/**
 * Created by agenthun on 16/8/28.
 */
public class Parentheses {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("B-small-attempt.in"));

        OutputStream outputStream = new FileOutputStream(new File("D-large.out"));
        PrintWriter pw = new PrintWriter(outputStream);

        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();

            int res = 0;
            System.out.println("Case #" + i + ": " + res);
            pw.println("Case #" + i + ": " + res);
        }
        pw.flush();
        pw.close();
    }
}
