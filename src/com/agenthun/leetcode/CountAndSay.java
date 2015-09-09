package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/9/10.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n <= 0) return null;
        String result = "1";
        int i = 1;

        while (i < n) {
            StringBuilder stringBuilder = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) count++;
                else {
                    stringBuilder.append(count);
                    stringBuilder.append(result.charAt(j - 1));
                    count = 1;
                }
            }
            stringBuilder.append(count);
            stringBuilder.append(result.charAt(result.length() - 1));
            result = stringBuilder.toString();
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 11;
        System.out.println("n = " + n);
        System.out.println("countAndSay(n) = " + new CountAndSay().countAndSay(n));
    }
}
