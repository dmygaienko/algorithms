package com.mygaienko.common.algorithms.leetcode.meeting_scheduler;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    /**
     * [[216397070,363167701],[98730764,158208909],[441003187,466254040],[558239978,678368334],[683942980,717766451]]
     * [[50490609,222653186],[512711631,670791418],[730229023,802410205],[812553104,891266775],[230032010,399152578]]
     * 456085
     */
    @Test
    public void test() {
        Solution solution = new Solution();
        List<Integer> actual = solution.minAvailableDuration(
                new int[][]{{216397070, 363167701}, {98730764, 158208909}, {441003187, 466254040}, {558239978, 678368334}, {683942980, 717766451}},
                new int[][]{{50490609, 222653186}, {512711631, 670791418}, {730229023, 802410205}, {812553104, 891266775}, {230032010, 399152578}},
                456085);

        assertThat(actual).isEqualTo(List.of(98730764,99186849));
    }
}