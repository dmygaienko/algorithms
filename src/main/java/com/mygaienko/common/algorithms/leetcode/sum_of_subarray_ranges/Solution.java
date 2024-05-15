package com.mygaienko.common.algorithms.leetcode.sum_of_subarray_ranges;

import java.util.Stack;

//  https://leetcode.com/problems/sum-of-subarray-ranges/editorial/
class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long answer = 0;
        Stack<Integer> monoIncrStack = new Stack<Integer>();

        // Find the sum of all the minimum.
        for (int right = 0; right <= n; ++right) {
            while (!monoIncrStack.isEmpty() && (right == n || nums[monoIncrStack.peek()] >= nums[right])) {
                int mid = monoIncrStack.peek();
                monoIncrStack.pop();
                int left = monoIncrStack.isEmpty() ? -1 : monoIncrStack.peek();
                answer -= (long) nums[mid] * (right - mid) * (mid - left);
            }
            monoIncrStack.add(right);
        }

        // Find the sum of all the maximum.
        var monoDecrStack = new Stack<Integer>();
        for (int right = 0; right <= n; ++right) {
            while (!monoDecrStack.isEmpty() && (right == n || nums[monoDecrStack.peek()] <= nums[right])) {
                int mid = monoDecrStack.peek();
                monoDecrStack.pop();
                int left = monoDecrStack.isEmpty() ? -1 : monoDecrStack.peek();
                answer += (long) nums[mid] * (right - mid) * (mid - left);
            }
            monoDecrStack.add(right);
        }
        return answer;
    }
}
