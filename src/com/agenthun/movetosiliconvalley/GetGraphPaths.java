package com.agenthun.movetosiliconvalley;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by agenthun on 15/11/11.
 */
public class GetGraphPaths {
    class GraphNode {
        int val;
        ArrayList<GraphNode> nexts;
    }

    int getGraphPaths(GraphNode a, GraphNode b, int n) {
        Queue<GraphNode> currQue = new LinkedList<>();
        currQue.add(a);
        int count = 0, steps = 0;
        while (currQue.size() > 0 && steps <= n) {
            Queue<GraphNode> nextQue = new LinkedList<>();
            steps++;
            while (currQue.size() > 0) {
                GraphNode node = currQue.poll();
                for (GraphNode next :
                        node.nexts) {
                    if (next == b && steps == n) {
                        count++;
                    }
                    nextQue.add(next);
                }
            }
            currQue = nextQue;
        }
        return count;
    }
}
