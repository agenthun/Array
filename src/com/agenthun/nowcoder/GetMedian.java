package com.agenthun.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by agenthun on 16/3/2.
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class GetMedian {
    List<Integer> list = new ArrayList<>();

    //内置排序, List用Collections, 数组用Arrays
    public void Insert(Integer num) {
        list.add(num);
        Collections.sort(list);
    }

    public Double GetMedian() {
        double result = 0;
        int size = list.size();
        if (size == 0) return 0.0;

        int mid = size >> 1;

        //通过长度是否奇数/偶数
        if ((size & 1) == 1) {
            result = list.get(mid);
        } else {
            result = ((double) (list.get(mid - 1) + list.get(mid))) / 2;
        }
        return result;
    }
}
