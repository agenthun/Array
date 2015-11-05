package com.agenthun.movetosiliconvalley;

import java.util.ArrayList;

/**
 * Created by agenthun on 15/11/5.
 */
public class Bucketfill {
    void bucketfill(ArrayList<ArrayList<Integer>> image, int newcolor, int x, int y) {
        int m = image.size();
        int n = image.get(0).size();
        int oldcolor = image.get(x).get(y);
        if (oldcolor == newcolor) return;
        image.get(x).set(y, newcolor);

        //left
        if (x > 0 && image.get(x - 1).get(y) == oldcolor) {
            bucketfill(image, newcolor, x - 1, y);
        }
        //up
        if (y > 0 && image.get(x).get(y - 1) == oldcolor) {
            bucketfill(image, newcolor, x, y - 1);
        }
        //right
        if (x < m - 1 && image.get(x + 1).get(y) == oldcolor) {
            bucketfill(image, newcolor, x + 1, y);
        }
        //down
        if (y < n - 1 && image.get(x).get(y + 1) == oldcolor) {
            bucketfill(image, newcolor, x, y + 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> image = new ArrayList<>();
        ArrayList<Integer> imagerow = new ArrayList<>();
        imagerow.add(0x10);
        imagerow.add(0x11);
        imagerow.add(0x12);
        imagerow.add(0x13);
        imagerow.add(0x14);
        imagerow.add(0x15);
        image.add(imagerow);

        imagerow = new ArrayList<>();
        imagerow.add(0x20);
        imagerow.add(0x21);
        imagerow.add(0x21);
        imagerow.add(0x23);
        imagerow.add(0x24);
        imagerow.add(0x25);
        image.add(imagerow);

        for (int i = 0; i < image.size(); i++) {
            for (int j = 0; j < image.get(i).size(); j++) {
                System.out.print(Integer.toHexString(image.get(i).get(j)) + " ");
            }
            System.out.println();
        }
        // for test
        int newColor = 0xff;
        int x = 1, y = 1;
        System.out.println("newColor = " + Integer.toHexString(newColor));
        System.out.println("x = " + x + ", y = " + y);
        new Bucketfill().bucketfill(image, newColor, x, y);

        for (int i = 0; i < image.size(); i++) {
            for (int j = 0; j < image.get(i).size(); j++) {
                System.out.print(Integer.toHexString(image.get(i).get(j)) + " ");
            }
            System.out.println();
        }
    }
}
