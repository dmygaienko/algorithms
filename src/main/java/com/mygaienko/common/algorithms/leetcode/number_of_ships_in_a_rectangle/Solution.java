package com.mygaienko.common.algorithms.leetcode.number_of_ships_in_a_rectangle;

class Solution {

    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if (bottomLeft[0] > topRight[0] || bottomLeft[1] > topRight[1]) return 0;

        var hasShips = sea.hasShips(topRight, bottomLeft);

        if (!hasShips) return 0;
        if (topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]) return 1;

        var midX = (topRight[0] + bottomLeft[0]) / 2;
        var midY = (topRight[1] + bottomLeft[1]) / 2;

        int counter = 0;
        counter += countShips(sea, new int[]{midX, midY}, bottomLeft);
        counter += countShips(sea, topRight, new int[]{midX + 1, midY + 1});
        counter += countShips(sea, new int[]{topRight[0], midY}, new int[]{midX + 1, bottomLeft[1]});
        counter += countShips(sea, new int[]{midX, topRight[1]}, new int[]{bottomLeft[0], midY + 1});

        return counter;
    }

}

interface Sea {
    boolean hasShips(int[] topRight, int[] bottomLeft);
}
