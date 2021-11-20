package com.mygaienko.common.algorithms.leetcode.number_of_matching_subsequences;

import java.util.HashMap;
import java.util.Map;

/**
 * 792. Number of Matching Subsequences
 * https://leetcode.com/problems/number-of-matching-subsequences/
 */
class Solution {

    public int numMatchingSubseq(String s, String[] words) {

        int result = 0;
        Map<String, Boolean> dp = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String next = words[i];

            boolean isSubseq = dp.computeIfAbsent(next, k -> isSubseq(next, s));

            if (isSubseq) {
                ++result;
            }
        }

        return result;
    }

    public boolean isSubseq(String subseq, String s) {

        int j = 0;
        for (int i = 0; i < subseq.length(); i++) {
            char c = subseq.charAt(i);

            int subSufLength = subseq.length() - (i + 1);
            int strSufLength = s.length() - (j + 1);
            if (subSufLength > strSufLength) {
                return false;
            }

            while(j < s.length()) {
                strSufLength = s.length() - (j + 1);
                if (subSufLength > strSufLength) {
                    return false;
                }

                if (c == s.charAt(j)) {
                    if (i == subseq.length() -1) {
                        return true;
                    }

                    j++;
                    break;
                }

                j++;
            }
        }


        return false;
    }
}
