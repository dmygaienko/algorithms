package com.mygaienko.common.algorithms.leetcode.majority_element_ii;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {

        Integer candidate1 = null;
        Integer candidate2 = null;

        var count1 = 0;
        var count2 = 0;

        for (int num : nums) {
            if (candidate1 != null && candidate1 == num) {
                count1++;
            } else if(candidate2 != null && candidate2 == num) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1++;
            } else if (count2 == 0) {
                candidate2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0; count2 = 0;
        for (int num : nums) {
            if (candidate1 != null && candidate1 == num) {
                count1++;
            } else if (candidate2 != null && candidate2 == num) {
                count2++;
            }
        }

        var majority = new ArrayList<Integer>();
        if (count1 > nums.length / 3) {
            majority.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            majority.add(candidate2);
        }
        return majority;
    }
}
