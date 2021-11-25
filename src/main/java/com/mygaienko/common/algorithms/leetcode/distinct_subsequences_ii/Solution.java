package com.mygaienko.common.algorithms.leetcode.distinct_subsequences_ii;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * abc - 7
     * @param s
     * @return
     *
     * abc
     *
     * a
     * ab
     * abc
     * b
     * bc
     * c
     *
     * ac
     *
     * 123
     *
     *  23
     * 1 3
     *  23
     * 12
     * 1
     *  2
     *   3
     *
     * 1234
     *  23
     *  2
     *   3
     */
    public int distinctSubseqII(String s) {
        int distinct = 0;

        Set<String> uniqSeq = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subseq = s.substring(i, j);
                if (subseq.length() > 2) {
                    distinct += generateSubSeq(subseq, uniqSeq);
                }
                distinct = uniqSeq.add(subseq) ? distinct + 1 : distinct;
            }
        }
        System.out.println(uniqSeq);
        return distinct;
    }

    private int generateSubSeq(String subseq, Set<String> uniqSeq) {
        int distinct = 0;

        for (int i = 1; i < subseq.length()-1; i++) {
            StringBuilder sb = new StringBuilder(subseq);
            sb.deleteCharAt(i);
            String newSubSeq = sb.toString();
            distinct = uniqSeq.add(newSubSeq) ? distinct + 1 : distinct;
            distinct += generateSubSeq(newSubSeq, uniqSeq);
        }

        return distinct;
    }

}



/*

abcde
abcd



* */
