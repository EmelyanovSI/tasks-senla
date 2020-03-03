package com.senlainc.task6;

import java.util.Arrays;

public class Task6 {

    public final thing[] things;
    public final knapsack ks;

    public Task6() {
        things = new thing[(int) Math.round(Math.random() * 100)];
        for (int i = 0; i < things.length; ++i) {
            things[i] = new thing();
        }
        ks = new knapsack();
    }

    public static class thing {
        public final int weight;
        public final int cost;

        public thing() {
            this.weight = (int) Math.round(Math.random() * 10);
            this.cost = (int) Math.round(Math.random() * 10);
        }

        @Override
        public String toString() {
            return String.format("weight = %2d, cost = %2d\n", weight, cost);
        }
    }

    public static class knapsack {
        public final int capacity;

        public knapsack() {
            this.capacity = (int) Math.round(Math.random() * 100);
        }
    }

    public int pack(thing[] things, knapsack ks) {
        int[][] dp = new int[ks.capacity + 1][things.length + 1];
        for (int j = 1; j <= things.length; ++j) {
            for (int w = 1; w <= ks.capacity; ++w) {
                dp[w][j] = things[j - 1].weight <= w
                        ? Math.max(dp[w][j - 1], dp[w - things[j - 1].weight][j - 1] + things[j - 1].cost)
                        : dp[w][j - 1];
            }
        }
        return dp[ks.capacity][things.length];
    }

    public void print() {
        System.out.println(this.toString() + "total cost of packed items: " + pack(things, ks));
    }

    @Override
    public String toString() {
        return String.format(
                "things:\n %s\nnumber of things: %d\nknapsack capacity: %d\n",
                Arrays.toString(things), things.length, ks.capacity
        );
    }

}
