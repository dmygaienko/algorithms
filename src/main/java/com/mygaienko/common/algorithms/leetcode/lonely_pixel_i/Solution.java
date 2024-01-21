package com.mygaienko.common.algorithms.leetcode.lonely_pixel_i;

import java.util.Arrays;

class Solution {
    // iterate horizontally and save column if only one B ( M * N )
    // iterate vertically and save row if only one B ( M * N )
    // iterate over horizontally array and check whether vertically containt the same values ( M )
    public int findLonelyPixel(char[][] picture) {
        var vertical = new int[picture.length];
        Arrays.fill(vertical, -1);

        var horizontal = new int[picture[0].length];
        Arrays.fill(horizontal, -1);

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    if (vertical[i] == -1) {
                        vertical[i] = j;
                    } else {
                        vertical[i] = -2;
                    }

                    if (horizontal[j] == -1) {
                        horizontal[j] = i;
                    } else {
                        horizontal[j] = -2;
                    }
                }
            }
        }

        var result = 0;
        for (int j = 0; j < horizontal.length; j++) {
            var nextI = horizontal[j];
            if (nextI >= 0 && vertical[nextI] == j) {
                result++;
            }
        }

        return result;
    }
}