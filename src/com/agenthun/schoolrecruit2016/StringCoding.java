package com.agenthun.schoolrecruit2016;

import java.util.*;

/**
 * Created by Daydreamer on 2016/7/9.
 * 请设计一个算法，给一个字符串进行二进制编码，使得编码后字符串的长度最短。
 * 输入描述:
 * 每组数据一行，为待编码的字符串。保证字符串长度小于等于1000。
 * 输出描述:
 * 一行输出最短的编码后长度。
 * 输入例子:
 * MT-TECH-TEAM
 * 输出例子:
 * 33
 */
public class StringCoding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();

            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                Character c = str.charAt(i);
                int value = map.containsKey(c) ? map.get(c) + 1 : 1;
                map.put(c, value);
            }
            Set<Map.Entry<Character, Integer>> set = map.entrySet();

            Queue<Node> queue = new PriorityQueue<>();
            for (Map.Entry<Character, Integer> object :
                    set) {
                Node node = new Node();
                node.context = object.getKey();
                node.priority = object.getValue();
                queue.add(node);
            }

            Node root = null;
            while (queue.size() != 1) {
                Node node1 = queue.poll();
                Node node2 = queue.poll();

                root = new Node();
                root.left = node1;
                root.right = node2;
                root.priority = node1.priority + node2.priority;
                queue.add(root);
            }

            getMap(root, 0, map);
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                count += map.get(str.charAt(i));
            }
            System.out.println(count);
        }
    }

    private static void getMap(Node root, int deep, Map<Character, Integer> map) {
        if (root.left == null && root.right == null) {
            map.put(root.context, deep);
            return;
        }
        getMap(root.left, deep + 1, map);
        getMap(root.right, deep + 1, map);
    }

    static class Node implements Comparable<Node> {
        int value;
        Character context;
        int priority;
        Node left;
        Node right;

        @Override
        public int compareTo(Node o) {
            int numberA = this.priority;
            int numberB = o.priority;
            if (numberA > numberB)
                return 1;
            else if (numberA < numberB)
                return -1;
            else
                return 0;
        }
    }
}
