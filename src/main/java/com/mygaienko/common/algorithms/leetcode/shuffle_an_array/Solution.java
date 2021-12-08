package com.mygaienko.common.algorithms.leetcode.shuffle_an_array;

import java.util.Arrays;
import java.util.Random;

/**
 * 384. Shuffle an Array https://leetcode.com/problems/shuffle-an-array/
 */
class Solution {

    private final int[] origin;
    private final Random random = new Random();

    public Solution(int[] nums) {
        origin = nums;
    }

    public int[] reset() {
        return origin;
    }

    public int[] shuffle() {
        int[] copied = Arrays.copyOf(origin, origin.length);
        for (int i = 0; i < copied.length; i++) {
            int j = i + random.nextInt(copied.length - i);

            int temp = copied[i];
            copied[i] = copied[j];
            copied[j] = temp;
        }
        return copied;
    }
}

