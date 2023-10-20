package com.mygaienko.common.algorithms.leetcode.remove_colored_pieces_if_both_neighbors_are_the_same_color;

class Solution {

    // make move
    // if 'A' then to win there should any 'A' moves, but not 'B' moves else
    // if 'B' then to win there should any 'B' moves, but not 'A' moves else
    // and memoize top-down calculation
    public boolean winnerOfGame(String colors) {
        var wins = 0;

        var aCount = 0;
        var bCount = 0;
        for (int i = 0; i < colors.length(); i++) {
            if (colors.charAt(i) == 'A') {
                aCount++;
                bCount = 0;

                if (aCount >= 3) {
                    wins++;
                }
            } else {
                bCount++;
                aCount = 0;

                if (bCount >= 3) {
                    wins--;
                }
            }
        }

        return wins > 0;
    }

}
