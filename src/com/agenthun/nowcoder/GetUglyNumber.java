package com.agenthun.nowcoder;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by agenthun on 16/2/16.
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {
        List<Integer> x2 = new LinkedList<>();
        List<Integer> x3 = new LinkedList<>();
        List<Integer> x5 = new LinkedList<>();
        x2.add(1);
        x3.add(1);
        x5.add(1);
        int result = 0;

        for (int i = 0; i < index; i++) {
            result = Math.min(x2.get(0), Math.min(x3.get(0), x5.get(0)));
            if (x2.get(0) == result) x2.remove(0);
            if (x3.get(0) == result) x3.remove(0);
            if (x5.get(0) == result) x5.remove(0);
            x2.add(result * 2);
            x3.add(result * 3);
            x5.add(result * 5);
        }
        return result;
    }
}
