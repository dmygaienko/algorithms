package com.mygaienko.common.algorithms.leetcode.the_number_of_weak_characters_in_the_game;

import java.util.Arrays;

class Solution {

    public int numberOfWeakCharacters(int[][] properties) {

        Arrays.sort(properties, (a, b) -> a[0] + a[1] - b[0] - b[1]);

        int weak = 0;

        for (int i = 0; i < properties.length; i++) {
            int[] curr = properties[i];
            int sum = curr[0] + curr[1];

            for (int j = properties.length - 1; j > i; j--) {
                int[] strong = properties[j];

                if (curr[0] < strong[0] && curr[1] < strong[1]) {
                    weak++;
                    break;
                } else if (sum >= strong[0] + strong[1]) {
                    break;
                }
            }
        }

        return weak;
    }


}
