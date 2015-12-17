package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/12/17.
 */
public class IsAggregatedNumber {
    boolean isAggregatedNumber(String num) {
        for (int i = 0; i <= num.length() / 2; i++) {
            for (int j = i + 1; j <= num.length() / 2 + 1; j++) {
                if (isMatch(i, j, num)) return true;
            }
        }
        return false;
    }

    private boolean isMatch(int i, int j, String num) {
        String first = num.substring(0, i);
        String second = num.substring(i, j);
        StringBuffer sb = new StringBuffer();
        sb.append(first);
        sb.append(second);
        while (sb.length() < num.length()) {
            String third = "";
            try {
                third = Integer.toString(Integer.parseInt(first) + Integer.parseInt(second));
            } catch (Exception e) {
                return false;
            }
            sb.append(third);
            first = second;
            second = third;
        }
        return (num.equals(sb.toString()));
    }
}
