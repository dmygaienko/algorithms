package com.mygaienko.common.algorithms.leetcode.find_the_index_of_the_large_integer;

class Solution {
    public int getIndex(ArrayReader reader) {
        var left = 0;
        var right = reader.length() - 1;

        while (left < right) {
            var offset = 0;
            if ((right - left + 1) % 2 != 0) {
                offset = 1;
                left++;
            }
            var mid = left + (right - left) / 2;
            var cmp = reader.compareSub(left, mid, mid + 1, right);
            if (cmp == 1) {
                if (left + 1 == right) return left;
                right = mid;
            } else if (cmp == -1) {
                if (left + 1 == right) return right;
                left = mid;
            } else if (offset == 1) {
                return left - 1;
            }
        }

        return -1;
    }
}

interface ArrayReader {
    int compareSub(int l, int r, int x, int y);

    int length();
}