package com.mygaienko.common.algorithms.leetcode.longest_substring_with_at_most_two_distinct_characters;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void testCcaabbb() {
        int actual = solution.lengthOfLongestSubstringTwoDistinct("ccaabbb");
        assertEquals(5, actual);
    }

}