package com.mygaienko.common.algorithms.leetcode.divide_chocolate;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.maximizeSweetness(new int[]{1, 2, 3, 4, 5}, 2);
        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void test2() {
        var actual = solution.maximizeSweetness(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 5);
        assertThat(actual).isEqualTo(6);
    }

    @Test
    public void test3() {
        var actual = solution.maximizeSweetness(new int[]{5, 6, 7, 8, 9, 1, 2, 3, 4}, 8);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test4() {
        var actual = solution.maximizeSweetness(new int[]
                {
                        93138, 60229, 11179, 91723, 85722, 58195, 95146, 85049, 33816, 96902,
                        90688, 49428, 12942, 92258, 79248, 34754, 84744, 36020, 92601, 27208,
                        28080, 47608, 56185, 30986, 99000, 75061, 86087, 81803, 49219, 97866,
                        40688, 45222, 13997, 38184, 93314, 39449, 11014, 45643, 34874, 12590,
                        92531, 41891, 4581, 19342, 4254, 65419, 74418, 37309, 72577, 29710,
                        70849, 48726, 4065, 8711, 65258, 66877, 61625, 2362, 78453, 44042,
                        15437, 69222, 53745, 18492, 34470, 95699, 14178, 24256, 86504, 63646,
                        34805, 84171, 30979, 784, 35720, 4666, 86966, 82187, 44100, 75253,
                        60649, 96874, 55457, 76446, 53927, 45725, 11740, 12169, 70093, 89884,
                        98535, 44881, 94654, 70810, 56558, 43993, 26318, 86350, 42786, 26313
                }, 81);
        assertThat(actual).isEqualTo(26318);
    }

}