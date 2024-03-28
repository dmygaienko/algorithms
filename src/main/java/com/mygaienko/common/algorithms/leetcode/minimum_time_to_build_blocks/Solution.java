package com.mygaienko.common.algorithms.leetcode.minimum_time_to_build_blocks;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int minBuildTime(int[] blocks, int split) {
        Integer[] boxed = Arrays.stream(blocks).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed, Comparator.reverseOrder());
        var memo = new int[blocks.length + 1][blocks.length + 1];
        for (var row : memo) {
            Arrays.fill(row, -1);
        }
        return minBuildTime(boxed, split, memo, 0, 1);
    }

    private int minBuildTime(Integer[] blocks, int split, int[][] memo, int blockIndex, int workers) {
        // Base cases
        if (blockIndex == blocks.length) {
            return 0;
        }
        if (workers == 0) {
            return Integer.MAX_VALUE;
        }
        if (workers >= blocks.length - blockIndex) {
            return blocks[blockIndex];
        }

        if (memo[workers][blockIndex] != -1) {
            return memo[workers][blockIndex];
        }

        var workTime = Math.max(blocks[blockIndex], minBuildTime(blocks, split, memo, blockIndex + 1, workers - 1));
        var splitTime = split + minBuildTime(blocks, split, memo, blockIndex, Math.min(2 * workers, blocks.length - blockIndex));

        memo[workers][blockIndex] = Math.min(splitTime, workTime);
        return memo[workers][blockIndex];
    }

}