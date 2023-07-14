package com.mygaienko.common.algorithms.leetcode.flatten_2d_vector;

class Vector2D {

    private final int[][] vec;

    int x = 0;
    int y = -1;

    boolean found;

    public Vector2D(int[][] vec) {
        this.vec = vec;
    }

    public int next() {
        return found ? getNext() : hasNext() ? getNext() : Integer.MIN_VALUE;
    }

    private int getNext() {
        found = false;
        return vec[x][y];
    }

    public boolean hasNext() {
        if (found) return true;

        boolean notFound = false;
        while (!notFound && x < vec.length) {
            if (y + 1 < vec[x].length) {
                y = y + 1;
                found = true;
                return true;
            }

            x = x + 1;
            y = -1;
        }
        return notFound;
    }

}
