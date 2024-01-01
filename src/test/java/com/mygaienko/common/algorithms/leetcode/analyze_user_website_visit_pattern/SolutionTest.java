package com.mygaienko.common.algorithms.leetcode.analyze_user_website_visit_pattern;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test1() {
        var actual = solution.mostVisitedPattern(
                new String[]{"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"},
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                new String[]{"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"}
        );
        assertThat(actual).isEqualTo(List.of("home", "about", "career"));
    }

    @Test
    public void test2() {
        var actual = solution.mostVisitedPattern(
                new String[]{"ua", "ua", "ua", "ub", "ub", "ub"},
                new int[]{1, 2, 3, 4, 5, 6},
                new String[]{"a", "b", "a", "a", "b", "c"}
        );
        assertThat(actual).isEqualTo(List.of("a", "b", "a"));
    }

    @Test
    public void test3() {
        var actual = solution.mostVisitedPattern(
                new String[]{"h", "eiy", "cq", "h", "cq", "txldsscx", "cq", "txldsscx", "h", "cq", "cq"},
                new int[]{527896567, 334462937, 517687281, 134127993, 859112386, 159548699, 51100299, 444082139, 926837079, 317455832, 411747930},
                new String[]{"hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "yljmntrclw",
                        "hibympufi", "yljmntrclw"}
        );
        assertThat(actual).isEqualTo(List.of("hibympufi", "hibympufi", "yljmntrclw"));
    }

    @Test
    public void test4() {
        var actual = solution.mostVisitedPattern(
                new String[]{"zkiikgv", "zkiikgv", "zkiikgv", "zkiikgv"},
                new int[]{436363475, 710406388, 386655081, 797150921},
                new String[]{"wnaaxbfhxp", "mryxsjc", "oz", "wlarkzzqht"}
        );
        assertThat(actual).isEqualTo(List.of("oz", "mryxsjc", "wlarkzzqht"));
    }

}