package com.mygaienko.common.algorithms.leetcode.fair_distribution_of_cookies;

import java.util.Arrays;

class SolutionV2 {

    // calculate sum of cookies
    // find optimal distribution sum / k
    // sort
    // go with two pointers, and try to pick optimal distribution (with +- 1 cookies)

    // [8,15,10,20,8]
    // [20,15,10,8,8]

    // calculate sum of cookies
    // find optimal distribution sum / k
    // sort
    // go with binary search (probably use seen set)
    public int distributeCookies(int[] cookies, int k) {
        int max = 0;
        int sum = 0;
        for (var cookie : cookies) {
            sum += cookie;
        }
        var optimal = sum / k;
        Arrays.sort(cookies);

        for (int i = 0; i < k; i++) {
            var current = 0;
            while (current < optimal) {
                var target = optimal - current;

                int left = 0;
                int right = cookies.length - 1;

                while (left < right) {
                    int mid = left + (right - left) / 2;
                    int next = cookies[mid];

                    while (next < 0) {
                        next = cookies[mid++];
                    }

                    if (next <= target) {
                        current += next;
                        cookies[mid] = -cookies[mid];
                        break;
                    } else {
                        right = mid;
                    }
                }
            }

            max = Math.max(max, current);
        }

        return max;
    }

}
