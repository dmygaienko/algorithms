package com.mygaienko.common.algorithms.leetcode.minimize_the_maximum_difference_of_pairs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class SolutionV3 {

    // option 1
    // iterate overs nums and put element to hashmap count
    // for each pair iterate and found whether it has duplicate or found nearest element

    // option 2
    // sort nums
    // iterate over nums and calc pair with next value and put pair to the heap

    public int minimizeMax(int[] nums, int p) {
        var minMax = 0;
        var count = 0;

        var frequencies = new HashMap<Integer, Integer>();
        for (var val : nums) {
            frequencies.compute(val, (k, v) -> v == null ? 1 : v + 1);
        }

        Arrays.sort(nums);
        var heap = new PriorityQueue<int[]>(Comparator.comparing(a -> a[1] - a[0]));

        for (int i = 0; i + 1 < nums.length; i++) {
            var curr = nums[i];
            var next = nums[i + 1];
            heap.offer(new int[]{curr, next});
        }

        while (!heap.isEmpty() && count < p) {
            var pair = heap.poll();
            var curr = pair[0];
            var next = pair[1];

            if (frequencies.get(curr) <= 0 || frequencies.get(next) <= 0 || (curr == next && frequencies.get(next) < 2))
                continue;

            minMax = Math.max(minMax, next - curr);

            frequencies.compute(curr, (k, v) -> v - 1);
            frequencies.compute(next, (k, v) -> v - 1);
            count++;
        }

        return minMax;
    }

}
