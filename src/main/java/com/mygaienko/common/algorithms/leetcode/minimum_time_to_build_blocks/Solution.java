package com.mygaienko.common.algorithms.leetcode.minimum_time_to_build_blocks;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int minBuildTime(int[] blocks, int split) {
        Integer[] boxed = Arrays.stream(blocks).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed, Comparator.reverseOrder());
        return minBuildTime(boxed, split, 1, 0, 0);
    }

    private int minBuildTime(Integer[] blocks, int split, int workers, int time, int blockIndex) {
        if (blockIndex + workers >= blocks.length) {
            return time + max(blocks, blockIndex);
        }

        var minBuildTime = Integer.MAX_VALUE;
        for (int i = 1; i <= workers; i++) { // for each available worker to split
            var freeWorkers = workers - i;
            var deltaTime = split;
            var nextBlockIndex = blockIndex;

            // verify option to make a work
            for (int j = 1; j <= freeWorkers && nextBlockIndex < blocks.length; j++) {
                deltaTime = Math.max(deltaTime, blocks[nextBlockIndex]);
                nextBlockIndex++;
            }

            var currBuildTime = Math.max(deltaTime, minBuildTime(blocks, split, i * 2, time + split, nextBlockIndex));
            minBuildTime = Math.min(minBuildTime, currBuildTime);
        }
        return minBuildTime;
    }

    private int max(Integer[] blocks, int index) {
        var max = Integer.MIN_VALUE;

        for (int i = index; i < blocks.length; i++) {
            max = Math.max(max, blocks[i]);
        }

        return max;
    }

}