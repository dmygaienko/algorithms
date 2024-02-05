package com.mygaienko.common.algorithms.leetcode.guess_the_majority_in_a_hidden_array;

class Solution {

    int countEqual = 1;
    int countDistinct = 0;
    int indexDiffer = -1;


    public int guessMajority(ArrayReader reader) {
        var res0123 = reader.query(0, 1, 2, 3);
        var res1234 = reader.query(1, 2, 3, 4);

        for (int i = 4; i < reader.length(); i++) {
            apply(res0123 == reader.query(1, 2, 3, i), i);
        }

        apply(res1234 == reader.query(0, 2, 3, 4), 1);
        apply(res1234 == reader.query(0, 1, 3, 4), 2);
        apply(res1234 == reader.query(0, 1, 2, 4), 3);

        return countEqual > countDistinct ? 0 : countDistinct > countEqual ? indexDiffer : -1;
    }

    void apply(boolean equal, int index) {
        if (equal) {
            countEqual++;
        } else {
            countDistinct++;
            indexDiffer = index;
        }
    }
}

interface ArrayReader {

    int query(int a, int b, int c, int d);

    int length();

};
