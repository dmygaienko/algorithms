package com.mygaienko.common.algorithms.leetcode.web_crawler;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        assertThat(solution.getHost("http://news.yahoo.com/news/topics/")).isEqualTo("http://news.yahoo.com");
    }

}