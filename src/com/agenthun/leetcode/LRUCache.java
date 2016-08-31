package com.agenthun.leetcode;

import java.util.HashMap;

/**
 * Created by agenthun on 15/11/17.
 */
public class LRUCache {
    //Node 双向链表,每个节点是一个键值对
    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    int capacity;

    HashMap<Integer, Node> map = new HashMap<>();
    Node head = null;
    Node end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    //根据Map的键获取出(移出)Node值
    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n); //移出node
            setHead(n); //重新设置node头节点
            return n.value;
        }
        return -1;
    }

    public void remove(Node n) {
        //修改node前一节点的next
        if (n.pre != null) {
            n.pre.next = n.next;
        } else {
            head = n.next;
        }

        //修改node后一节点的pre
        if (n.next != null) {
            n.next.pre = n.pre;
        } else {
            end = n.pre;
        }
    }

    public void setHead(Node n) {
        n.next = head;
        n.pre = null;
        if (head != null) {
            head.pre = n;
        }

        head = n;
        if (end == null) {
            end = head;
        }
    }

    //设置Map的键值对
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node created = new Node(key, value);
            if (map.size() >= capacity) {
                //移除最近不使用的元素
                map.remove(end.key);
                remove(end);
                setHead(created);
            } else {
                setHead(created);
            }
            map.put(key, created);
        }
    }
}
