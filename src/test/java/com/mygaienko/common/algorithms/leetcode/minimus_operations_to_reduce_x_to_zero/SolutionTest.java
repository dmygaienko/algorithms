package com.mygaienko.common.algorithms.leetcode.minimus_operations_to_reduce_x_to_zero;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        var actual = solution.minOperations(new int[]{1, 1, 4, 2, 3}, 5);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test071() {
        var actual = solution.minOperations(new int[]{1, 1}, 3);
        assertThat(actual).isEqualTo(-1);
    }

    @Test
    public void test1() {
        var actual = solution.minOperations(new int[]{5, 6, 7, 8, 9}, 10);
        assertThat(actual).isEqualTo(-1);
    }

    @Test
    public void test2() {
        var actual = solution.minOperations(new int[] {3,2,20,1,1,3}, 10);
        assertThat(actual).isEqualTo(5);
    }

    @Test
    public void test() {
        var actual = solution.minOperations(new int[]{1241,8769,9151,3211,2314,8007,3713,5835,2176,8227,5251,9229,904,1899,5513,7878,8663,3804,2685,3501,1204,9742,2578,8849,1120,4687,5902,9929,6769,8171,5150,1343,9619,3973,3273,6427,47,8701,2741,7402,1412,2223,8152,805,6726,9128,2794,7137,6725,4279,7200,5582,9583,7443,6573,7221,1423,4859,2608,3772,7437,2581,975,3893,9172,3,3113,2978,9300,6029,4958,229,4630,653,1421,5512,5392,7287,8643,4495,2640,8047,7268,3878,6010,8070,7560,8931,76,6502,5952,4871,5986,4935,3015,8263,7497,8153,384,1136}, 894887480);
        assertThat(actual).isEqualTo(-1);
    }

    @Test
    public void test13() {
        var actual = solution.minOperations(new int[] {5207,5594,477,6938,8010,7606,2356,6349,3970,751,5997,6114,9903,3859,6900,7722,2378,1996,8902,228,4461,90,7321,7893,4879,9987,1146,8177,1073,7254,5088,402,4266,6443,3084,1403,5357,2565,3470,3639,9468,8932,3119,5839,8008,2712,2735,825,4236,3703,2711,530,9630,1521,2174,5027,4833,3483,445,8300,3194,8784,279,3097,1491,9864,4992,6164,2043,5364,9192,9649,9944,7230,7224,585,3722,5628,4833,8379,3967,5649,2554,5828,4331,3547,7847,5433,3394,4968,9983,3540,9224,6216,9665,8070,31,3555,4198,2626,9553,9724,4503,1951,9980,3975,6025,8928,2952,911,3674,6620,3745,6548,4985,5206,5777,1908,6029,2322,2626,2188,5639}, 565610);
        assertThat(actual).isEqualTo(113);
    }
}