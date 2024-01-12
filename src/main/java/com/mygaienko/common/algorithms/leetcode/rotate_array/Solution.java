package com.mygaienko.common.algorithms.leetcode.rotate_array;

public class Solution {

    public void rotate(int[] nums, int k) {
        int N = nums.length;
        k = k % N;
        int count = 0;

        for (int startIndex = 0; count < N; startIndex++) {
            var currentIndex = startIndex;
            var prevValue = nums[startIndex];
            do {
                var nextIndex = (currentIndex + k) % N;
                var tempValue = nums[nextIndex];
                nums[nextIndex] = prevValue;

                prevValue = tempValue;
                currentIndex = nextIndex;
                count++;
            } while (startIndex != currentIndex);
        }
    }

}
