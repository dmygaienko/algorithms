package com.mygaienko.common.algorithms.condingame.hard.super_computer;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static java.nio.charset.StandardCharsets.UTF_8;


public class SolutionTest {

    @Test
    public void test() throws Exception {
        String inputs = getGameInput1();
        System.setIn(new ByteArrayInputStream(inputs.getBytes(UTF_8)));
        ArraySolution.main(new String[]{});
    }

    public String getGameInput() {
        return "4\n" +
                "2 5\n" +
                "9 7\n" +
                "15 6\n" +
                "9 3";
    }

    //{3=[5], 9=[2], 11=[6], 16=[9], 24=[5]}
    public String getGameInput1() {
        return "5\n" +
                "3 5\n" +
                "11 6\n" +
                "9 2\n" +
                "16 9\n" +
                "24 5";
    }

    @Test
    public void testLargeNumberOfScientists() throws Exception {
        InputStream inputStream = getClass().getResourceAsStream("large_number_of_scientists.txt");
        System.setIn(inputStream);
        ArraySolution.main(new String[]{});
    }

}