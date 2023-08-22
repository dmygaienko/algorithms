package com.mygaienko.common.algorithms.leetcode.filling_bookcase_shelves;

import java.util.HashMap;
import java.util.Map;

class Solution {

    int min = Integer.MAX_VALUE;
    Map<Integer, Integer> memo = new HashMap<>();
    int[][] books;
    int shelfWidth;


    public int minHeightShelves(int[][] books, int shelfWidth) {
        if (books == null || books[0] == null || shelfWidth == 0) return 0;
        this.books = books;
        this.shelfWidth = shelfWidth;
        //init first step
        height(0, 0, books[0][0], books[0][1], books[0][1]);

        return min;
    }

    public int height(int prevIndex, int prevBookShelf, int prevWidth, int prevMax, int prevSumHeight) {
        int nextIndex = prevIndex + 1;

        int localHeight = Integer.MAX_VALUE;
//        if (memo.containsKey(nextIndex)) {
//            localHeight = Math.min(localHeight, prevSumHeight + memo.get(nextIndex));
//            if (localHeight < min) {
//                min = localHeight;
//                return min;
//            }
//        }

        if (prevIndex == books.length - 1) {
            min = Math.min(min, prevSumHeight);
            return prevSumHeight;
        }

//        if (min < prevSumHeight || min < localHeight) {
//            return Integer.MAX_VALUE;
//        }

        int nextBookShelf = prevBookShelf + 1;
        int currWidth = books[nextIndex][0];
        int currHeight = books[nextIndex][1];
        int currSumWidth = prevWidth + currWidth;

        if (currSumWidth <= shelfWidth) {

            if (prevMax >= currHeight) { // prev shelf prev max height
                localHeight = Math.min(localHeight, height(nextIndex, prevBookShelf, currSumWidth, prevMax, prevSumHeight));
            } else { // prev shelf new max height + new height sum
                int heightDiff = currHeight - prevMax;
                localHeight = Math.min(localHeight, height(nextIndex, prevBookShelf, currSumWidth, currHeight, prevSumHeight + heightDiff));
            }
        }

        // experiment to add book to next shelf
        localHeight = Math.min(localHeight, height(nextIndex, nextBookShelf, currWidth, currHeight, prevSumHeight + currHeight));

//        if (localHeight != Integer.MAX_VALUE) {
//            int finalDiff = localHeight - prevSumHeight;
//            memo.compute(nextIndex, (k, v) -> v == null ? finalDiff : Math.min(v, finalDiff));
//        }

        return localHeight;
    }

}

