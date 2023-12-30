package com.mygaienko.common.algorithms.leetcode.reorder_data_in_log_files;


import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.reorderLogFiles(new String[]{
                "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo", "a2 act car"
        });
        assertThat(actual).isEqualTo(new String[]{
                "a2 act car", "g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7"
        });
    }

}