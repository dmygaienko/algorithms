package com.mygaienko.common.algorithms.leetcode.similar_string_groups;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.numSimilarGroups(new String[]{"tars", "rats", "arts", "star"});
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test1() {
        var actual = solution.numSimilarGroups(new String[]{"tars", "rats", "arts", "astr", "star"});
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test2() {
        var actual = solution.numSimilarGroups(new String[]{"omv", "ovm"});
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test4() {
        var actual = solution.numSimilarGroups(new String[]{"ajdidocuyh", "djdyaohuic", "ddjyhuicoa", "djdhaoyuic", "ddjoiuycha", "ddhoiuycja", "ajdydocuih", "ddjiouycha", "ajdydohuic", "ddjyouicha"});
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test75() {
        var actual = solution.numSimilarGroups(new String[]{
                "kccomwcgcs", "socgcmcwkc", "sgckwcmcoc", "coswcmcgkc", "cowkccmsgc",
                "cosgmccwkc", "sgmkwcccoc", "coswmccgkc", "kowcccmsgc", "kgcomwcccs"});
        assertThat(actual).isEqualTo(5);
    }

}