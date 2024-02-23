package com.mygaienko.common.algorithms.leetcode.valid_palindrome_iii;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        assertThat(solution.isValidPalindrome("abcdeca", 2)).isTrue();
    }

    @Test
    public void test2() {
        assertThat(solution.isValidPalindrome("abbababa", 1)).isTrue();
    }

    @Test
    public void test31() {
        assertThat(solution.isValidPalindrome("baaba", 3)).isTrue();
    }

    @Test
    public void test32() {
        assertThat(solution.isValidPalindrome("baaabaa", 2)).isTrue();
    }

    @Test
    public void test49() {
        assertThat(solution.isValidPalindrome("aaabaabaa", 1)).isTrue();
    }

    @Test
    public void test50() {
        assertThat(solution.isValidPalindrome("aadbaabaa", 1)).isTrue();
    }

    @Test
    public void test51() {
        assertThat(solution.isValidPalindrome("egaaidhedchebfahcgabhhafieigighfafcceabcgahhgicbifhaffdabfbadedbefdigg" +
                "gdifagfbfhhcdidgbchafafcdaiaecfhfcccgadaicdhadhahhdghiigiahiaiegeaidhbddbhdgghiigeiafeccabgeehihaaefhah" +
                "cfchaffbgcafieedbhaeifcgehdfecgfbeeaifhhhfafabhaefgfddagggahfbccddacbebcfahagecdfebabbaigabefgbdfdabbg" +
                "eahhgebafeeadfccdbaefbeeehhdhabhafcbdfbfgddbefgihabdaihdcdbdifdeeghifgagecdiaeeddcaiiaccdggaabeaeaffhg" +
                "hgihihfchhfgfhaabfdfbeehhhihffddgfcifdhcgiaedebibbaeacahcgccihhfbgeaabhieahfcffdeiccbeddcddigdaahhdfg" +
                "gggbieebceefiedbcgagaibgihhgbfceba", 343)).isTrue();
    }

}