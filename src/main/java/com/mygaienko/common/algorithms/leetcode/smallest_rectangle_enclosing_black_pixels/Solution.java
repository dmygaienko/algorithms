package com.mygaienko.common.algorithms.leetcode.smallest_rectangle_enclosing_black_pixels;

/**
 * 2D Binary Search
 */
class Solution {

    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;

        var minY = findColumn(image, 0, y, 0, m, true);
        var maxY = findColumn(image, y + 1, n, 0, m, false);

        var minX = findRow(image, 0, x, minY, maxY, true);
        var maxX = findRow(image, x + 1, m, minY, maxY, false);

        return (maxX - minX) * (maxY - minY);
    }

    private int findColumn(char[][] image, int from, int to, int top, int bottom, boolean whiteToBlack) {
        while (from != to) {
            var mid = (to + from) / 2;
            int i = top;
            while (i < bottom && image[i][mid] == '0') {
                i++;
            }

            if (i < bottom == whiteToBlack) { // i < bottom means the column mid has black pixel
                to = mid;
            } else {
                from = mid + 1;
            }
        }

        return from;

    }

    private int findRow(char[][] image, int from, int to, int left, int right, boolean whiteToBlack) {
        while (from != to) {
            var mid = (to + from) / 2;

            int j = left;
            while (j < right && image[mid][j] == '0') {
                j++;
            }

            if (j < right == whiteToBlack) { // j < right means the row mid has black pixel
                to = mid;
            } else {
                from = mid + 1;
            }
        }

        return from;
    }
}
