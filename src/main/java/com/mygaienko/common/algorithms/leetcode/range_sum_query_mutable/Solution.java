package com.mygaienko.common.algorithms.leetcode.range_sum_query_mutable;

import java.util.Arrays;

/**
 * Fenwick Tree (Binary Index Tree)
 */
class NumArray {

    int[] tree;
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        tree = new int[nums.length + 1];
        System.arraycopy(nums, 0, tree, 1, nums.length);

        for (int i = 1; i < tree.length; i++) {
            int p = i + (i & -i); //index to parent
            if (p < tree.length) {
                tree[p] = tree[p] + tree[i];
            }
        }
    }

    public void update(int i, int val) {
        var delta = val - nums[i];
        nums[i] = val;

        i++;
        while (i < tree.length) {
            tree[i] += delta;
            i += i & -i; // add last set bit
        }
    }

    public int sumRange(int left, int right) {
        return sum(right) - sum(left - 1);
    }

    private int sum(int i) {
        int sum = 0;

        i++;
        while (i > 0) {
            sum += tree[i];
            i -= i & -i; // flip the last set bit;
        }
        return sum;
    }

}