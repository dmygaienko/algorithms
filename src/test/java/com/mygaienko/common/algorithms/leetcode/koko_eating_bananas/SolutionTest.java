package com.mygaienko.common.algorithms.leetcode.koko_eating_bananas;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        var actual = solution.minEatingSpeed(new int[]{
                3,6,7,11
        }, 8);

        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void test4() {
        var actual = solution.minEatingSpeed(new int[]{312884470}, 312884469);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test1() {
        var actual = solution.minEatingSpeed(new int[]{
                332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673,
                679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097,
                692137887, 718203285, 629455728, 941802184
        }, 823855818);

        assertThat(actual).isEqualTo(14);
    }

    @Test
    public void test125() {
        var actual = solution.minEatingSpeed(new int[]{
                1000000000, 1000000000
        }, 3);

        assertThat(actual).isEqualTo(1000000000);
    }
}