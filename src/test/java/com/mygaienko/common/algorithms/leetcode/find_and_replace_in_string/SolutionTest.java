package com.mygaienko.common.algorithms.leetcode.find_and_replace_in_string;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void testFindReplaceString() {
        String actual = solution.findReplaceString("abcd",
                new int[]{0, 2},
                new String[]{"a", "cd"},
                new String[]{"eee", "ffff"});
        assertEquals("eeebffff", actual);
    }

    /**
     * "abcd"
     * [0, 2]
     * ["ab","ec"]
     * ["eee","ffff"]
     */
    @Test
    public void testFindReplaceString2() {
        String actual = solution.findReplaceString("abcd",
                new int[]{0, 2},
                new String[]{"ab", "ec"},
                new String[]{"eee", "ffff"});
        assertEquals("eeecd", actual);
    }

    /**
     * "vmokgggqzp"
     * [3,5,1]
     * ["kg","ggq","mo"]
     * ["s","so","bfr"]
     */
    @Test
    public void testFindReplaceString3() {
        String actual = solution.findReplaceString("vmokgggqzp",
                new int[]{3, 5, 1},
                new String[]{"kg", "ggq", "mo"},
                new String[]{"s","so","bfr"});
        assertEquals("vbfrssozp", actual);
    }

}