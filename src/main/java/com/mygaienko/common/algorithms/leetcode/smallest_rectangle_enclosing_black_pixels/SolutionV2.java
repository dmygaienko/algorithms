package com.mygaienko.common.algorithms.leetcode.smallest_rectangle_enclosing_black_pixels;

import java.util.ArrayDeque;

class SolutionV2 {

    int[][] dirs = new int[][]{
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public int minArea(char[][] image, int x, int y) {
        var visited = new boolean[image.length][image[0].length];

        var minX = Integer.MAX_VALUE;
        var minY = Integer.MAX_VALUE;

        var maxX = Integer.MIN_VALUE;
        var maxY = Integer.MIN_VALUE;

        var queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            var next = queue.poll();
            var nextX = next[0];
            var nextY = next[1];

            if (visited[nextX][nextY]) continue;
            visited[nextX][nextY] = true;

            minX = Math.min(minX, nextX);
            minY = Math.min(minY, nextY);

            maxX = Math.max(maxX, nextX);
            maxY = Math.max(maxY, nextY);

            for (var dir : dirs) {
                var neighX = nextX + dir[0];
                var neighY = nextY + dir[1];

                if (neighX >= 0 && neighX < image.length
                        && neighY >= 0 && neighY < image[0].length
                        && image[neighX][neighY] == '1'
                        && !visited[neighX][neighY]) {
                    queue.offer(new int[]{neighX, neighY});
                }
            }
        }

        return (maxX - minX + 1) * (maxY - minY + 1);
    }
}
