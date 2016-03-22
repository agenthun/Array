package com.agenthun.schoolrecruit2016;

/**
 * Created by agenthun on 16/3/22.
 */

import java.util.*;

public class Main {
    private static int compare(int g1, int g2, List<Cmp> records) {
        int res = 0;
        int tempLight = 0;
        int tempHeavy = 0;
        for (int i = 0; i < records.size(); i++) {
            Cmp cmp = records.get(i);
            if ((cmp.light >= g1 && cmp.heavy <= g2)
                    || (cmp.light >= g1 && cmp.light < g2) || (cmp.heavy >= g1 && cmp.heavy < g2)
                    || (cmp.light > g1 && cmp.light <= g2) || (cmp.heavy > g1 && cmp.heavy <= g2)
                    ) return -1;
            if (cmp.light >= g2 && cmp.heavy <= g1
                    || (cmp.light >= g2 && cmp.light < g1) || (cmp.heavy >= g2 && cmp.heavy < g1)
                    || (cmp.light > g2 && cmp.light <= g1) || (cmp.heavy > g2 && cmp.heavy <= g1)
                    ) return 1;
            if (cmp.light >= g2 && cmp.heavy <= g1)
                tempLight = cmp.light;
            tempHeavy = cmp.heavy;
        }
        return res;
    }

    public static void main(String[] args) {
        List<Cmp> list = new ArrayList<>();
        Cmp cmp = new Cmp();
        cmp.light = 1;
        cmp.heavy = 2;
        list.add(cmp);

    }


}

class Cmp {
    int light;
    int heavy;
}
