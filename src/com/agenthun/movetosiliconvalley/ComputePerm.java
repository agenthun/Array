package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/10/6.
 */
public class ComputePerm {
    boolean computePerm(String signature, int n, int level, StringBuffer sb, boolean[] used) {
        if (level == n - 1) {
            System.out.println(sb.toString());
            return true;
        }

        int i = sb.charAt(sb.length() - 1) - '0';
        if (signature.charAt(level) == 'I') {
            for (int j = i + 1; j <= n; j++) {
                if (used[j]) {
                    continue;
                }
                sb.append(j);
                used[j] = true;
                computePerm(signature, n, level + 1, sb, used);
                sb.setLength(sb.length() - 1);
                used[j] = false;
            }
        } else {
            for (int j = i; j < i; j++) {
                if (used[j]) {
                    continue;
                }
                sb.append(j);
                used[j] = true;
                computePerm(signature, n, level + 1, sb, used);
                sb.setLength(sb.length() - 1);
                used[j] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "DDIIDI";
        System.out.println("s=" + s);
//      (new ComputePerm()).computePerm(s, 7,2);
    }
}