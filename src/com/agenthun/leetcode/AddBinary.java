package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/9/19.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || a.length() < 1) return b;
        if (b == null || b.length() < 1) return a;

        int pa = a.length() - 1;
        int pb = b.length() - 1;
        int count = 0;

        StringBuilder s = new StringBuilder();

        while (pa >= 0 || pb >= 0) {
            int va = 0;
            int vb = 0;

            if (pa >= 0) {
                va = a.charAt(pa) == '0' ? 0 : 1;
                pa--;
            }
            if (pb >= 0) {
                vb = b.charAt(pb) == '0' ? 0 : 1;
                pb--;
            }

            int sum = va + vb + count;
            if (sum >= 2) {
                s.append(String.valueOf(sum - 2));
                count = 1;
            } else {
                count = 0;
                s.append(String.valueOf(sum));
            }
        }

        if (count == 1) s.append("1");
        s.reverse();
        return s.toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("addBinary(a, b) = " + new AddBinary().addBinary(a, b));
    }
}
