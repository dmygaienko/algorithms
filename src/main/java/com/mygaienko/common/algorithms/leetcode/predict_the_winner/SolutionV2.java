package com.mygaienko.common.algorithms.leetcode.predict_the_winner;

// package com.mygaienko.common.algorithms.leetcode.predict_the_winner;

// package com.mygaienko.common.algorithms.leetcode.predict_the_winner;

// package com.mygaienko.common.algorithms.leetcode.predict_the_winner;

class SolutionV2 {
    int countOne = 0;
    int countTwo = 0;

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int s = 0;
        int e = nums.length - 1;
        boolean first = true;
        while (s <= e) {
            int delta = Integer.MIN_VALUE;
            if (s + 1 < n && e - 1 >= 0 && s + 1 < e - 1) {
                int nextMax = Math.max(nums[s], nums[e - 1]);
                int max = Math.max(Math.max(nums[s], nums[s + 1]), nums[e - 1]);
                int min = Math.min(Math.min(nums[s], nums[s + 1]), nums[e - 1]);
                int avg = (nums[s] < max && nums[s] > min) ? nums[s] :
                        (nums[s + 1] < max && nums[s + 1] > min) ? nums[s + 1] :
                                (nums[e - 1] < max && nums[e - 1] >= min) ? nums[e - 1] : Math.max(nums[s], nums[s + 1]);

                if (nextMax + min < avg + nums[e] || (nums[s] + nums[e - 1] < nums[s + 1] + nums[e])) {
                    delta = nums[e];
                    e--;
                }
            } else if (nums[s] < nums[e]) {
                delta = nums[e];
                e--;
            }
            if (delta == Integer.MIN_VALUE) {
                delta = nums[s];
                s++;
            }
            apply(first, delta);
            first = !first;
        }

        return countOne >= countTwo;
    }

    private void apply(boolean first, int delta) {
        if (first) {
            countOne += delta;
        } else {
            countTwo += delta;
        }
    }

}


