package com.mygaienko.common.algorithms.leetcode.longest_absolute_file_path;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void test1() {
        int actual = solution.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
        assertEquals(20, actual);
    }

    @Test
    public void test2() {
        int actual = solution.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
        assertEquals(32, actual);
    }

    @Test
    public void test3() {
        int actual = solution.lengthLongestPath("a");
        assertEquals(0, actual);
    }

    @Test
    public void test4() {
        int actual = solution.lengthLongestPath("file1.txt\nfile2.txt\nlongfile.txt");
        assertEquals(12, actual);
    }

    @Test
    public void test5() {
        int actual = solution.lengthLongestPath("dir\n        file.txt");
        assertEquals(16, actual);
    }

}