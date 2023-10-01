package com.mygaienko.common.algorithms.leetcode.reorganize_string;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.reorganizeString("aab");
        assertThat(actual).isEqualTo("aba");
    }

    @Test
    public void test24() {
        var actual = solution.reorganizeString("baaba");
        assertThat(actual).isEqualTo("ababa");
    }

    @Test
    public void test42() {
        var actual = solution.reorganizeString("bfrbs");
        assertThat(actual).isEqualTo("bfsbr");
    }

    @Test
    public void test58() {
        var actual = solution.reorganizeString("kkkkzrkatkwpkkkktrq");
        assertThat(actual).isEqualTo("krktktkakrkzkpkwkqk");
    }

    @Test
    public void test62() {
        var actual = solution.reorganizeString("gpneqthatplqrofqgwwfmhzxjddhyupnluzkkysofgqawjyrwhfgdpkhiqgkpupgdeonipvptkfqluytogoljiaexrnxckeofqojltdjuujcnjdjohqbrzzzznymyrbbcjjmacdqyhpwtcmmlpjbqictcvjgswqyqcjcribfmyajsodsqicwallszoqkxjsoskxxstdeavavnqnrjelsxxlermaxmlgqaaeuvneovumneazaegtlztlxhihpqbajjwjujyorhldxxbdocklrklgvnoubegjrfrscigsemporrjkiyncugkksedfpuiqzbmwdaagqlxivxawccavcrtelscbewrqaxvhknxpyzdzjuhvoizxkcxuxllbkyyygtqdngpffvdvtivnbnlsurzroxyxcevsojbhjhujqxenhlvlgzcsibcxwomfpyevumljanfpjpyhsqxxnaewknpnuhpeffdvtyjqvvyzjeoctivqwann");
        assertThat(actual).isEqualTo("jqjxjljqjxjljqxnjnaejqcxlxcnlvjqeaoaenopxyjlcvqvcpqaenjxoylyoalvrcupjeqnxgqgxcahyslodvknurpjejplexgcqoahysunvdrkzkrhzxjpilqcteogvyafsdnusunezkbxhrqlpjciwdygtoavfvapfzsumkenjrxbqhltwcidogygoxysavpuzfbnkmjerilqhtdcwcdkwaogxvsymfupbznhrjeitqlqtulodckgawpyvxmsfenbzhijrjivrdtqucolxwgkpayzfmsehbnbhgntijvqdrklcuxowsypazemfmecfihbgjtnurqvkdlawxoszpypzqyhemcbifvnjgutrolkdasxwxsjwezpqmhygfbcvindrutoaklkablzsxjpewcymqghftnvidouruomrsakbxzlqwpjceyifghtdvnvdpnaoumksrjlxbqzwhyceitgfgtfzlsmknapvychqjrudiwboex");
    }

    @Test
    public void test59() {
        var actual = solution.reorganizeString("abbabbaaab");
        assertThat(actual).isEqualTo("ababababab");
    }
}