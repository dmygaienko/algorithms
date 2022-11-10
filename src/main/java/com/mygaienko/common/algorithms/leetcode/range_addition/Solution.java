package com.mygaienko.common.algorithms.leetcode.range_addition;

/**
 * nice to read segment tree with lazy propagation
 * https://leetcode.com/problems/range-addition/solutions/1100795/java-segment-tree-with-lazy-propagation-o-m-logn/
 */
public class Solution {

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] array = new int[length];

        for (int i = 0; i < updates.length; i++) {
            int[] nextUpdate = updates[i];
            int start = nextUpdate[0];
            int end = nextUpdate[1];
            int delta = nextUpdate[2];

            array[start] += delta;

            if (end + 1 < length) {
                array[end + 1] -= delta;
            }
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += array[i];
            array[i] = sum;
        }
        return array;
    }

}
