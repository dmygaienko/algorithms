package com.mygaienko.common.algorithms.leetcode.text_justification;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void testFullJustify() {
        List<String> actual = solution.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
        List<String> expected = List.of("This    is    an", "example  of text", "justification.  ");
        assertEquals(expected, actual);
    }

    @Test
    public void testFullJustify2() {
        List<String> actual = solution.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16);
        List<String> expected = List.of("What   must   be","acknowledgment  ","shall be        ");
        assertEquals(expected, actual);
    }

    @Test
    public void testFullJustify3() {
        List<String> actual = solution.fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20);
        List<String> expected = List.of("Science  is  what we","understand      well","enough to explain to","a  computer.  Art is","everything  else  we","do                  ");
        assertEquals(expected, actual);
    }

    @Test
    public void testFullJustify4() {
        List<String> actual = solution.fullJustify(new String[]{"Here","is","an","example","of","text","justification."}, 14);
        List<String> expected = List.of("Here   is   an","example     of","text          ","justification.");
        assertEquals(expected, actual);
    }

}