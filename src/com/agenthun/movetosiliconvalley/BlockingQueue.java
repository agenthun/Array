package com.agenthun.movetosiliconvalley;

import java.util.LinkedList;

/**
 * Created by agenthun on 15/10/23.
 */
public class BlockingQueue<T> {
    private LinkedList<T> list;
    private int limit;

    public BlockingQueue(int limit) {
        this.limit = limit;
        list = new LinkedList<>();
    }

    public synchronized void put(T t) throws InterruptedException {
        while (list.size() == limit) {
            try {
                list.wait();
            } catch (InterruptedException e) {

            }
        }
        list.add(t);
        if (list.size() > 0) list.notifyAll();
    }

    public synchronized T get() throws InterruptedException {
        while (list.size() == 0) {
            try {
                list.wait();
            } catch (InterruptedException e) {

            }
        }
        T t = list.pop();
        list.notifyAll();
        return t;
    }
}
