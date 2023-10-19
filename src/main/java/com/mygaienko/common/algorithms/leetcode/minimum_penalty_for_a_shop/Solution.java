package com.mygaienko.common.algorithms.leetcode.minimum_penalty_for_a_shop;

class Solution {

    char YES = 'Y';

    public int bestClosingTime(String customers) {
        int yCount = 0;
        int nCount = 0;

        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == YES) {
                yCount++;
            } else {
                nCount++;
            }
        }

        int minPenalty = yCount;
        int minPenaltyTime = 0;

        int iYCount = 0;
        int iNCount = 0;
        for(int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == YES) {
                iYCount++;
            } else {
                iNCount++;
            }

            int iPenalty = yCount - iYCount + iNCount;

            if (minPenalty > iPenalty) {
                minPenalty = iPenalty;
                minPenaltyTime = i + 1;
            }

        }

        return minPenaltyTime;
    }
}
