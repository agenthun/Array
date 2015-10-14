package com.agenthun.movetosiliconvalley;

import java.util.Random;

/**
 * Created by agenthun on 15/10/15.
 */
public class RandWithWeights {

    int randWithWeights(int[] w) {
        int n = w.length;
        int[] dist = new int[n];
        dist[0] = w[0];
        for (int i = 1; i < n; i++) {
            dist[i] = w[i] + dist[i - 1];
        }
        Random random = new Random();
        int rand = random.nextInt(dist[n - 1]);
        for (int i = 0; i < n; i++) {
            if (rand < dist[i]) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] w = {1, 2, 3, 2, 4};
        for (int i = 0; i < w.length; i++) {
            System.out.print(w[i] + " ");
        }
        System.out.println();
        System.out.println("randWithWeights(w) = " + new RandWithWeights().randWithWeights(w));
        System.out.println("randWithWeights(w) = " + new RandWithWeights().randWithWeights(w));
        System.out.println("randWithWeights(w) = " + new RandWithWeights().randWithWeights(w));
    }
}
