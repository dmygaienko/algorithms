package com.mygaienko.common.algorithms.leetcode.search_in_a_sorted_array_of_unknown_size;

class Solution {

    private static int OUT_OF_BOUNDS = Integer.MAX_VALUE;

    public int search(ArrayReader reader, int target) {

        int[] bounds = findBounds(reader);
        int left = bounds[0];
        int right = bounds[1];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = reader.get(mid);
            if (value == target) {
                return mid;
            } else if (value < target) {
                left = mid + 1;
            } else { // value > target
                right = mid - 1;
            }
        }

        return -1;
    }

    private int[] findBounds(ArrayReader reader) {
        int right = 0;
        int add = 1;
        int left = 0;

        boolean found = false;
        while (!found) {
            left = left + add;
            int value = reader.get(left);
            if (value != OUT_OF_BOUNDS) {
                add = add * 2;
            } else {
                if (add == 1) {
                    found = true;
                }
                left = left - add;
                add = add / 2;
            }
        }

        return new int[] {right, left};
    }

}

interface ArrayReader {
    int get(int i);
}