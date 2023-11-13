package com.mygaienko.common.algorithms.leetcode.delete_and_earn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class SolutionV2 {
    class Solution {
        public int deleteAndEarn(int[] nums) {
            HashMap<Integer, Integer> points = new HashMap<>();

            // Precompute how many points we gain from taking an element
            for (int num : nums) {
                points.put(num, points.getOrDefault(num, 0) + num);
            }

            List<Integer> elements = new ArrayList<>(points.keySet());
            Collections.sort(elements);

            // Base cases
            int twoBack = 0;
            int oneBack = points.get(elements.get(0));

            for (int i = 1; i < elements.size(); i++) {
                int currentElement = elements.get(i);
                int temp = oneBack;
                if (currentElement == elements.get(i - 1) + 1) {
                    // The 2 elements are adjacent, cannot take both - apply normal recurrence
                    oneBack = Math.max(oneBack, twoBack + points.get(currentElement));
                } else {
                    // Otherwise, we don't need to worry about adjacent deletions
                    oneBack += points.get(currentElement);
                }

                twoBack = temp;
            }

            return oneBack;
        }
    }
}
