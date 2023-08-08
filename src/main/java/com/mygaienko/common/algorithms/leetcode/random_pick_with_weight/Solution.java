package com.mygaienko.common.algorithms.leetcode.random_pick_with_weight;

import java.util.Random;
import java.util.TreeMap;

class Solution {

    final long sum;
    final int[] arr;
    final Random random;
    final TreeMap<Long, Integer> tree;

    public Solution(int[] w) {
        int sum = 0;
        for (int val : w) {
            sum += val;
        }
        this.sum = sum;
        this.arr = w;
        this.random = new Random(sum);
        this.tree = initTree(w);
    }

    public int pickIndex() {
        long next = Math.abs(random.nextLong()) % sum;
        return tree.floorEntry(next).getValue();
    }

    private TreeMap<Long, Integer> initTree(int[] w) {
        long border = 0;
        TreeMap<Long, Integer> tree = new TreeMap<>();
        for (int i = 0; i < w.length; i++) {
            int val = w[i];
            tree.put(border, i);
            border += val;
        }

        return tree;
    }

}

