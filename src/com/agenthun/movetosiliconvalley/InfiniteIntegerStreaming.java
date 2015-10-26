package com.agenthun.movetosiliconvalley;

import java.util.ArrayList;

/**
 * Created by agenthun on 15/10/26.
 */
public class InfiniteIntegerStreaming {
    ArrayList<Integer> list = new ArrayList<>();

    void add(int num) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (num >= list.get(i))
                list.remove(i);
        }
        list.add(num);
    }

    int getMax() {
        return list.size() > 0 ? list.get(0) : Integer.MIN_VALUE;
    }
}
