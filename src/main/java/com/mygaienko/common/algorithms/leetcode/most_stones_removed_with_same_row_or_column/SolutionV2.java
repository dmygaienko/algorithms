package com.mygaienko.common.algorithms.leetcode.most_stones_removed_with_same_row_or_column;

class SolutionV2 {

    private int[][] dirs = new int[][]{
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    private static final int CLEAN = 0;
    private static final int VISITED = 2;
    private static final int STONE = 1;
    private static final int REMOVED = -1;

    public int removeStones(int[][] stones) {
        int[][] matrix = toMatrix(stones);

        int maxQty = 0;

        for (int[] stone : stones) {
            int x = stone[0];
            int y = stone[1];

            int qTy = removeStone(matrix, 0, x, y);
            maxQty += qTy;
        }

        return maxQty;
    }

    private int removeStone(int[][] matrix, int qty, int x, int y) {
        if (matrix[x][y] == VISITED || matrix[x][y] == REMOVED) return 0;

        boolean wasStone = false;
        if (matrix[x][y] == STONE) {
            matrix[x][y] = REMOVED;
            wasStone = true;
        } else if (matrix[x][y] == CLEAN) {
            matrix[x][y] = VISITED;
        }

        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            while (nextX >= 0 && nextX < matrix.length && nextY >= 0 && nextY < matrix[0].length) {
                if (wasStone && (matrix[nextX][nextY] == STONE)) {
                    qty += removeStone(matrix, 1, nextX, nextY);
                }

                nextX = nextX + dir[0];
                nextY = nextY + dir[1];
            }
        }

        return qty;
    }

    private int[][] toMatrix(int[][] stones) {
        int xSize = 0;
        int ySize = 0;
        for (int[] stone : stones) {
            xSize = Math.max(stone[0], xSize);
            ySize = Math.max(stone[1], ySize);
        }

        int[][] matrix = new int[xSize + 1][ySize + 1];
        for (int[] stone : stones) {
            matrix[stone[0]][stone[1]] = STONE;
        }
        return matrix;
    }

}
