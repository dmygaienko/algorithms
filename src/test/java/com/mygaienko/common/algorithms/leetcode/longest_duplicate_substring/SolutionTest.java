package com.mygaienko.common.algorithms.leetcode.longest_duplicate_substring;


import org.junit.Test;

import static com.mygaienko.common.util.FileUtils.readString;
import static org.junit.Assert.assertEquals;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void testBanana() {
        String substring = solution.longestDupSubstring("banana");
        assertEquals(substring, "ana");
    }

    @Test
    public void testAbcgjabc() {
        String substring = solution.longestDupSubstring("abcgjabc");
        assertEquals(substring, "abc");
    }

    @Test
    public void nameAbcd() {
        String substring = solution.longestDupSubstring("abcd");
        assertEquals(substring, "");
    }

    @Test
    public void nameAa() {
        String substring = solution.longestDupSubstring("aa");
        assertEquals(substring, "a");
    }

    @Test
    public void nameNnpxouomcofdjuujloanjimymadkuepightrfodmauhrsy() {
        String substring = solution.longestDupSubstring("nnpxouomcofdjuujloanjimymadkuepightrfodmauhrsy");
        assertEquals(substring, "ma");
    }

    @Test
    public void testNext3() {
        String substring = solution.longestDupSubstring("zxcvdqkfawuytt");
        assertEquals(substring, "t");
    }

    @Test
    public void testIsDubExistBanana() {
        int pos = solution.isDubExist("banana", 3);
        assertEquals(pos, 3);
    }

    @Test
    public void testIsDubExistNext() {
        int pos = solution.isDubExist("nnpxouomcofdjuujloanjimymadkuepightrfodmauhrsy", 2);
        assertEquals(pos, 39);
    }

    @Test
    public void testIsDubExistNext3() {
        int pos = solution.isDubExist("zxcvdqkfawuytt", 1);
        assertEquals(pos, 13);
    }

    @Test
    public void nameNext4() {
        String substring = solution.longestDupSubstring(readString(getClass(), "long_string.txt"));
        assertEquals(substring, "havbc");
    }

}