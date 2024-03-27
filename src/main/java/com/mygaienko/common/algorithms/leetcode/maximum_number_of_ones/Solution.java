package com.mygaienko.common.algorithms.leetcode.maximum_number_of_ones;

import java.util.PriorityQueue;

public class Solution {

    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        //count maximum frequencies
        var frequencies = new int[sideLength][sideLength];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                frequencies[i % sideLength][j % sideLength]++;
            }
        }

        //all frequencies to queue with descending sorting
        var queue = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                queue.offer(frequencies[i][j]);
            }
        }

        //add the most frequent points till maxOnes is over.
        var totalCount = 0;
        var maxOnesCount = 0;
        while (maxOnesCount < maxOnes) {
            totalCount += queue.poll();
            maxOnesCount++;
        }
        return totalCount;
    }
}
