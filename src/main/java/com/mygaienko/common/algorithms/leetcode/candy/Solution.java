package com.mygaienko.common.algorithms.leetcode.candy;

class Solution {

    public int candy(int[] ratings) {
        var count = 0;
        var currRating = 1;
        var prevRating = Integer.MAX_VALUE;
        Boolean increasing = null;

        for (int i = 0; i < ratings.length; i++) {
            if (i == 0) { //initial
                count += currRating;
            } else if (ratings[i - 1] < ratings[i]) { // increasing
                if (increasing != null && !increasing) {
                    if (prevRating <= currRating) {
                        count += currRating - prevRating + 1;
                        prevRating = Integer.MAX_VALUE;
                    }
                    currRating = 1;
                }

                currRating++;
                count += currRating;
                increasing = true;
            } else if (ratings[i - 1] > ratings[i]) { // decreasing
                if (increasing != null && increasing) {
                    prevRating = currRating;
                    currRating = 1;
                } else {
                    currRating++;
                }

                count += currRating;
                increasing = false;
            } else { // equals
                if (prevRating <= currRating) {
                    count += currRating - prevRating + 1;
                }
                currRating = 1;
                count += currRating;
                prevRating = Integer.MAX_VALUE;
                increasing = false;
            }
        }
        if (increasing != null && !increasing && prevRating <= currRating) {
            count += currRating - prevRating + 1;
        }

        return count;
    }

}