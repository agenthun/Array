package com.agenthun.schoolrecruit2016;

import java.io.*;
import java.util.Scanner;

/**
 * Created by agenthun on 16/8/28.
 */
public class GymSecrets {

    public static long getPowerSelf(long a, int n) {
        if (n == 0) return 1;
        if (n == 1) return a;
        if ((n & 1) == 0) {
            return getPowerSelf(a * a, n / 2);
        } else {
            return getPowerSelf(a * a, n / 2) * a;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/com/agenthun/schoolrecruit2016/B-small-attempt6.in"));

        OutputStream outputStream = new FileOutputStream(new File("src/com/agenthun/schoolrecruit2016/B-small-attempt6.out"));
        PrintWriter pw = new PrintWriter(outputStream);

        int T = scanner.nextInt();
        for (int k = 1; k <= T; k++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int N = scanner.nextInt();
            int K = scanner.nextInt();

            int count = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i != j) {
                        if (((getPowerSelf(i, A) + getPowerSelf(j, B)) % K) == 0) {
                            count++;
                        }
                    }
                }
            }

            System.out.println("Case #" + k + ": " + count);
            if (k < T) {
                pw.println("Case #" + k + ": " + count);
            } else {
                pw.print("Case #" + k + ": " + count);
            }
        }
        pw.flush();
        pw.close();
    }
}
