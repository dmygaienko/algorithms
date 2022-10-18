package com.mygaienko.common.algorithms.leetcode.group_shifted_strings;


import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test01() {
        var actual = solution.groupStrings(new String[] {"abc","bcd","acef","xyz","az","ba","a","z"});
        assertThat(actual).contains(List.of("az", "ba"), List.of("abc", "bcd", "xyz"), List.of("a","z"), List.of("acef"));
    }

    @Test
    public void test0() {
        var actual = solution.groupStrings(new String[] {"ab", "ba"});
        assertThat(actual).contains(List.of("ba"), List.of("ab"));
    }

    @Test
    public void test1() {
        var actual = solution.groupStrings(new String[] {"aa", "bb", "b"});
        assertThat(actual).contains(List.of("b"), List.of("aa", "bb"));
    }

    @Test
    public void test2() {
        var actual = solution.groupStrings(new String[] {
                "fpbnsbrkbcyzdmmmoisaa","cpjtwqcdwbldwwrryuclcngw","a","fnuqwejouqzrif","js","qcpr","zghmdiaqmfelr","iedda","l",
                "dgwlvcyubde","lpt","qzq","zkddvitlk","xbogegswmad","mkndeyrh","llofdjckor","lebzshcb","firomjjlidqpsdeqyn",
                "dclpiqbypjpfafukqmjnjg","lbpabjpcmkyivbtgdwhzlxa","wmalmuanxvjtgmerohskwil","yxgkdlwtkekavapflheieb","oraxvssurmzybmnzhw",
                "ohecvkfe","kknecibjnq","wuxnoibr","gkxpnpbfvjm","lwpphufxw","sbs","txb","ilbqahdzgij","i","zvuur","yfglchzpledkq","eqdf","nw",
                "aiplrzejplumda","d","huoybvhibgqibbwwdzhqhslb","rbnzendwnoklpyyyauemm"});
        assertThat(actual).contains(
                List.of("a","d","i","l"),
                List.of("eqdf","qcpr"),
                List.of("lpt","txb"),
                List.of("yfglchzpledkq","zghmdiaqmfelr"),
                List.of("kknecibjnq","llofdjckor"),

                List.of("cpjtwqcdwbldwwrryuclcngw","huoybvhibgqibbwwdzhqhslb"),
                List.of("lbpabjpcmkyivbtgdwhzlxa","wmalmuanxvjtgmerohskwil"),
                List.of("iedda","zvuur"),
                List.of("js","nw"),
                List.of("lebzshcb","ohecvkfe"),

                List.of("dgwlvcyubde","ilbqahdzgij"),
                List.of("lwpphufxw","zkddvitlk"),
                List.of("qzq","sbs"),
                List.of("dclpiqbypjpfafukqmjnjg","yxgkdlwtkekavapflheieb"),
                List.of("mkndeyrh","wuxnoibr"),

                List.of("firomjjlidqpsdeqyn","oraxvssurmzybmnzhw"),
                List.of("gkxpnpbfvjm","xbogegswmad"),
                List.of("fpbnsbrkbcyzdmmmoisaa","rbnzendwnoklpyyyauemm"),
                List.of("aiplrzejplumda","fnuqwejouqzrif")
        );
    }

    @Test
    public void test21() {
        var actual = solution.groupStrings(new String[] {
                "yfglchzpledkq","zghmdiaqmfelr"});
        assertThat(actual).contains(
                List.of("yfglchzpledkq","zghmdiaqmfelr")
        );
    }

    @Test
    public void test22() {
        var actual = solution.groupStrings(new String[] {"cpjtwqcdwbldwwrryuclcngw", "huoybvhibgqibbwwdzhqhslb"});
        assertThat(actual).contains(List.of("cpjtwqcdwbldwwrryuclcngw", "huoybvhibgqibbwwdzhqhslb"));
    }

    @Test
    public void test4() {
        var actual = solution.groupStrings(new String[] {"a", "a"});
        assertThat(actual).contains(List.of("a", "a"));
    }

}