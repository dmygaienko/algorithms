package com.mygaienko.common.algorithms.leetcode.strobogrammatic_number_ii;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test1() {
        List<String> strobogrammatic = solution.findStrobogrammatic(1);
        assertThat(strobogrammatic).containsExactlyInAnyOrder("0", "1", "8");
    }

    @Test
    public void test2() {
        List<String> strobogrammatic = solution.findStrobogrammatic(2);
        assertThat(strobogrammatic).containsExactlyInAnyOrder("11", "69", "88", "96");
    }

    @Test
    public void test3() {
        List<String> strobogrammatic = solution.findStrobogrammatic(3);
        assertThat(strobogrammatic).containsExactlyInAnyOrder("101","111","181","609","619","689","808","818","888","906","916","986");
    }

    @Test
    public void test4() {
        List<String> strobogrammatic = solution.findStrobogrammatic(4);
        assertThat(strobogrammatic).containsExactlyInAnyOrder("1001",
                "1111",
                "1691",
                "1881",
                "1961",
                "6009",
                "6119",
                "6699",
                "6889",
                "6969",
                "8008",
                "8118",
                "8698",
                "8888",
                "8968",
                "9006",
                "9116",
                "9696",
                "9886",
                "9966");
    }

//    @Test
//    public void test11() {
//        List<String> strobogrammatic = solution.findStrobogrammatic(11);
//        assertThat(strobogrammatic).containsExactlyInAnyOrder("101","111","181","609","619","689","808","818","888","906","916","986");
//    }
}