package com.agenthun.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agenthun on 15/11/16.
 */
public class RestoreIPAddresses {
    List<String> restoreIpAddresses(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> t = new ArrayList<>();
        dfs(result, s, 0, t);

        ArrayList<String> finalResult = new ArrayList<>();
        for (ArrayList<String> l :
                result) {
            StringBuilder sb = new StringBuilder();
            for (String str :
                    l) {
                sb.append(str + ".");
            }
            sb.setLength(sb.length() - 1);
            finalResult.add(sb.toString());
        }
        return finalResult;
    }

    private void dfs(ArrayList<ArrayList<String>> result, String s, int start, ArrayList<String> t) {
        if (t.size() >= 4 && start != s.length()) return;
        if ((t.size() + s.length() - start + 1) < 4) return;

        if (t.size() == 4 && start == s.length()) {
            ArrayList<String> temp = new ArrayList<>(t);
            result.add(temp);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length()) break;

            String sub = s.substring(start, start + i);
            if (i > 1 && s.charAt(start) == '0') {
                break;
            }

            if (Integer.valueOf(sub) > 255) break;

            t.add(sub);
            dfs(result, s, start + i, t);
            t.remove(t.size() - 1);
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println("s = " + s);
        List<String> ips = new RestoreIPAddresses().restoreIpAddresses(s);
        for (String ip :
                ips) {
            System.out.println("ip = " + ip);
        }
    }
}
