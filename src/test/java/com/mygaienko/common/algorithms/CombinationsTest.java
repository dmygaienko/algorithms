package com.mygaienko.common.algorithms;

import org.junit.Test;

import static com.mygaienko.common.algorithms.Combinations.countSubsets;

public class CombinationsTest {

    @Test
    public void testCountSubsets() {
        int[] input = {10, 20, 30, 40, 50};    // input array
        countSubsets(3, input);
    }

}