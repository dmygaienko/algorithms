package com.mygaienko.common.algorithms.leetcode.minimum_window_substring;

import com.mygaienko.common.util.FileUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        String actual = solution.minWindow("ADOBECODEBANC", "ABC");
        assertEquals("BANC", actual);
    }

    @Test
    public void test1() {
        String actual = solution.minWindow("a", "aa");
        assertEquals("", actual);
    }

    @Test
    public void test_aa_aa() {
        String actual = solution.minWindow("aa", "aa");
        assertEquals("aa", actual);
    }

    @Test
    public void test_baa_aa() {
        String actual = solution.minWindow("bba", "ab");
        assertEquals("ba", actual);
    }

//    @Test
//    public void test_very_long() {
//        String actual = solution.minWindow(
//                FileUtils.readString(getClass(), "long_s.txt"),
//                FileUtils.readString(getClass(), "long_t.txt"));
//        assertEquals(
//                "kgfidhktkjhlkbgjkylgdracfzjduycghkomrbfbkoowqwgaurizliesjnveoxmvjdjaepdqftmvsuyoogobrutahogxnvuxyezevfuaaiyufwjtezuxtpycfgasburzytdvazwakuxpsiiyhewctwgycgsgdkhdfnzfmvhwrellmvjvzfzsdgqgolorxvxciwjxtqvmxhxlcijeqiytqrzfcpyzlvbvrksmcoybxxpbgyfwgepzvrezg", actual);
//    }

    @Test
    public void test_acbbaca_aba() {
        String actual = solution.minWindow("acbbaca", "aba");
        assertEquals("baca", actual);
    }

    @Test
    public void test_aaabdabcefaecbef_abc() {
        String actual = solution.minWindow("aaabdabcefaecbef", "abc");
        assertEquals("abc", actual);
    }

    @Test
    public void test_aaaaaaaaaaaabbbbbcdd_abcdd() {
        String actual = solution.minWindow("aaaaaaaaaaaabbbbbcdd","abcdd");
        assertEquals("abbbbbcdd", actual);
    }

    @Test
    public void test_babbBba_Abbb() {
        String actual = solution.minWindow("babbBba","Abbb");
        assertEquals("", actual);
    }

}