package com.mygaienko.common.algorithms.leetcode.filling_bookcase_shelves;

class SolutionV2 {

    public int minHeightShelves(int[][] books, int shelfWidth) {
        if (books == null || books[0] == null || shelfWidth == 0) return 0;

        int N = books.length;

        int[][][] dp = new int[N][N][3];
        // books -> shelf -> width + maxHeight + sumHeights

        //init first step
        dp[0][0] = new int[]{books[0][0], books[0][1], books[0][1]};

        for (int i = 1; i < N; i++) {
            int currWidth = books[i][0];
            int currHeight = books[i][1];

            for (int j = 0; j < i; j++) {
                int[] prevRes = dp[i - 1][j]; // consider prev book on each shelf
                if (prevRes[2] == 0) continue;

                int prevWidth = prevRes[0];
                int prevMax = prevRes[1];
                int prevSumHeight = prevRes[2];

                int currSumWidth = prevWidth + currWidth;

                dp[i][j + 1] = new int[]{currWidth, currHeight, prevSumHeight + currHeight}; // experiment to add book to next shelf

                if (currSumWidth <= shelfWidth) {

                    if (prevMax >= currHeight && (dp[i][j][2] > prevSumHeight || dp[i][j][2] == 0)) { // prev shelf prev max height
                        dp[i][j] = new int[]{currSumWidth, prevMax, prevSumHeight};
                    } else if (prevMax < currHeight){ // prev shelf new max height + new height sum
                        int heightDiff = currHeight - prevMax;
                        if (dp[i][j][2] > prevSumHeight + heightDiff || dp[i][j][2] == 0) {
                            dp[i][j] = new int[]{currSumWidth, currHeight, prevSumHeight + heightDiff};
                        }
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp[N - 1].length; i++) {
            int[] res = dp[N - 1][i];
            if (res[2] == 0) continue;

            min = Math.min(min, res[2]);
        }

        return min;
    }

}
