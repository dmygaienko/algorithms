package com.mygaienko.common.algorithms.condingame.hard.super_computer;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static java.nio.charset.StandardCharsets.UTF_8;


public class SolutionTest {

    @Test
    public void testGameInput() throws Exception {
        test(getGameInput());
    }

    @Test
    public void testGameInput1() throws Exception {
        test(getGameInput1());
    }


    @Test
    public void testGameInput2() throws Exception {
        test(getGameInput2());
    }

    private void test(String inputs) {
        System.setIn(new ByteArrayInputStream(inputs.getBytes(UTF_8)));
        Solution.main(new String[]{});
    }

    private String getGameInput() {
        return "4\n" +
                "2 5\n" +
                "9 7\n" +
                "15 6\n" +
                "9 3";
    }

    private String getGameInput1() {
        return "5\n" +
                "3 5\n" +
                "11 6\n" +
                "9 2\n" +
                "16 9\n" +
                "24 5";
    }

    private String getGameInput2() {
        return "5\n" +
                "1 10\n" +
                "2 6\n" +
                "3 2\n" +
                "5 2\n" +
                "7 2";
    }

    @Test
    public void testLargeNumberOfScientists() throws Exception {
        InputStream inputStream = getClass().getResourceAsStream("large_number_of_scientists.txt");
        System.setIn(inputStream);
        Solution.main(new String[]{});
    }

}