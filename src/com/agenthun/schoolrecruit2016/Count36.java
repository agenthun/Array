package com.agenthun.schoolrecruit2016;

public class Count36 {
    public static void main(String[] args) {
        System.out.println(to36(147) + "+" + to36(1205) + "=" + to36(147 + 1205));
        System.out.println("43+xh=" + sum36("43", "xh"));
        System.out.println("48-2x=" + sub36("48", "2x"));
    }

    //10进制转36进制
    private static String to36(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int bit = n / 36;
            int rem = n % 36;
            sb.append(toChar(rem));
            n = bit;
        }
        return sb.reverse().toString();
    }

    //36进制加法
    private static String sum36(String n1, String n2) {
        int bit1 = n1.length();
        int bit2 = n2.length();
        int next = 0;
        StringBuilder sb = new StringBuilder();
        while (bit1 > 0 && bit2 > 0) {
            int bit = toInt(n1.charAt(bit1 - 1)) + toInt(n2.charAt(bit2 - 1)) + next;
            sb.append(toChar(bit % 36));
            next = bit / 36;
            bit1--;
            bit2--;
        }
        while (bit1 > 0) {
            int bit = toInt(n1.charAt(bit1 - 1)) + next;
            sb.append(toChar(bit % 36));
            next = bit / 36;
            bit1--;
        }
        while (bit2 > 0) {
            int bit = toInt(n1.charAt(bit2 - 1)) + next;
            sb.append(toChar(bit % 36));
            next = bit / 36;
            bit2--;
        }
        if (next > 0) {
            sb.append(toChar(next));
        }
        return sb.reverse().toString();
    }

    //36进制减法
    private static String sub36(String n1, String n2) {
        int bit1 = n1.length();
        int bit2 = n2.length();
        int next = 0;
        StringBuilder sb = new StringBuilder();
        while (bit1 > 0 && bit2 > 0) {
            int bit = toInt(n1.charAt(bit1 - 1)) - toInt(n2.charAt(bit2 - 1)) - next;
            if (bit < 0) {
                next = 1;
                sb.append(toChar(bit + 36));
            } else {
                sb.append(toChar(bit));
            }
            bit1--;
            bit2--;
        }
        while (bit1 > 0) {
            int bit = toInt(n1.charAt(bit1 - 1)) - next;
            if (bit < 0) {
                next = 1;
                sb.append(toChar(bit + 36));
            } else {
                sb.append(toChar(bit));
            }
            bit1--;
        }
        while (bit2 > 0) {
            int bit = -toInt(n2.charAt(bit2 - 1)) - next;
            if (bit < 0) {
                next = 1;
                sb.append(toChar(bit + 36));
            } else {
                sb.append(toChar(bit));
            }
            bit2--;
        }
        return sb.reverse().toString();
    }

    private static char toChar(int i) {
        if (i < 10) {
            return (char) ('0' + i);
        } else {
            return (char) ('a' + i - 10);
        }
    }

    private static int toInt(char c) {
        if (c <= '9' && c >= '0') {
            return c - '0';
        } else {
            return c - 'a' + 10;
        }
    }
}
