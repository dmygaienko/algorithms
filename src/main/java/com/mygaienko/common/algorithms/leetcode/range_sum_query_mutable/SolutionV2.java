package com.mygaienko.common.algorithms.leetcode.range_sum_query_mutable;

/**
 * Segment Tree
 */
class NumArrayV2 {

    int n;
    int[] nums;
    int[] tree;

    public NumArrayV2(int[] nums) {
        n = nums.length;
        this.nums = nums;
        tree = new int[n * 2];
        System.arraycopy(nums, 0, tree, n, n);
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    public void update(int i, int val) {
        i += n;
        tree[i] = val;

        while (i > 0) {
            int left = i;
            int right = i;

            if (i % 2 == 0) {
                right = i + 1;
            } else {
                left = i - 1;
            }

            tree[i / 2] = tree[left] + tree[right];
            i /= 2;
        }
    }

    public int sumRange(int left, int right) {
        left += n;
        right += n;
        int sum = 0;
        while (left <= right) {
            if (left % 2 == 1) {
                sum += tree[left];
                left++;
            }
            if (right % 2 == 0) {
                sum += tree[right];
                right--;
            }
            left /= 2;
            right /= 2;
        }

        return sum;
    }

}