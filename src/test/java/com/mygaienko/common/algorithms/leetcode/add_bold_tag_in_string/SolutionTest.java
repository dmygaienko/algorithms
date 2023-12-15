package com.mygaienko.common.algorithms.leetcode.add_bold_tag_in_string;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.addBoldTag("abcxyz123", new String[]{"abc", "123"});
        assertThat(actual).isEqualTo("<b>abc</b>xyz<b>123</b>");
    }

    @Test
    public void test1() {
        var actual = solution.addBoldTag("aaabbb", new String[]{"aa", "b"});
        assertThat(actual).isEqualTo("<b>aaabbb</b>");
    }

    @Test
    public void test11() {
        var actual = solution.addBoldTag("aaabbcc", new String[]{});
        assertThat(actual).isEqualTo("aaabbcc");
    }
}