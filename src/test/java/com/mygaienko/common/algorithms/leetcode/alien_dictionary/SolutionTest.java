package com.mygaienko.common.algorithms.leetcode.alien_dictionary;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private final Solution solution = new Solution();

    /**
     * w -> e
     * r -> t
     * e -> r
     * t -> f
     *
     * w -> e -> r -> t -> f
     */
    @Test
    public void alienOrder1() {
        String actual = solution.alienOrder(new String[] {"wrt","wrf","er","ett","rftt"});
        assertEquals( "wertf", actual);
    }

    @Test
    public void alienOrder2() {
        String actual = solution.alienOrder(new String[] {"z","x"});
        assertEquals("zx", actual);
    }

    @Test
    public void alienOrder3() {
        String actual = solution.alienOrder(new String[] {"z","x","z"});
        assertEquals("", actual);
    }

    @Test
    public void alienOrder4() {
        String actual = solution.alienOrder(new String[] {"zy","zx"});
        assertEquals("zyx", actual);
    }

    @Test
    public void alienOrder5() {
        String actual = solution.alienOrder(new String[] {"ab","adc"});
        assertEquals("cabd", actual);
    }

    @Test
    public void alienOrder6() {
        String actual = solution.alienOrder(new String[] {"abc","ab"});
        assertEquals("", actual);
    }

    @Test
    public void alienOrder7() {
        String actual = solution.alienOrder(new String[] {"z","x","a","zb","zx"});
        assertEquals("", actual);
    }

    @Test
    public void alienOrder8() {
        String actual = solution.alienOrder(new String[] {"vlxpwiqbsg","cpwqwqcd"});
        assertEquals("sgvlxpwiqbdc", actual);
    }

    @Test
    public void alienOrder9() {
        String actual = solution.alienOrder(new String[] {"wnlb"});
        assertEquals("wnlb", actual);
    }

    @Test
    public void alienOrder10() {
        String actual = solution.alienOrder(new String[] {"dvpzu","bq","lwp","akiljwjdu","vnkauhh","ogjgdsfk","tnkmxnj",
                "uvwa","zfe","dvgghw","yeyruhev","xymbbvo","m","n"});
        assertEquals("", actual);
    }

    @Test
    public void alienOrder11() {
        String actual = solution.alienOrder(new String[] {"ac","ab","zc","zb"});
        assertEquals("aczb", actual);
    }

    @Test
    public void alienOrder12() {
        String actual = solution.alienOrder(new String[] {"aba"});
        assertEquals("ab", actual);
    }

}