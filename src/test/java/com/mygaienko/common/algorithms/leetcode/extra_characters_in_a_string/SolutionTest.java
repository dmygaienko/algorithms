package com.mygaienko.common.algorithms.leetcode.extra_characters_in_a_string;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.minExtraChar("leetscode", new String[] {"leet", "code", "leetcode"});
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test1() {
        var actual = solution.minExtraChar("sayhelloworld", new String[] {"hello", "world"});
        assertThat(actual).isEqualTo(3);
    }


    // dwmodizxvvbosxxw
    // d - NO - 1
    // wmo
    // diz
    // x - NO - 2
    // v - 2
    // v - 2
    // b - NO - 3
    // o - 3
    // s - NO - 4
    // x - NO - 5
    // x - NO - 6
    // w - NO - 7
    //
    // dwmodizxvvbosxxw
    // 1111111222334567
    @Test
    public void test2() {
        var actual = solution.minExtraChar("dwmodizxvvbosxxw",
                new String[] {
                        "ox","lb","diz","gu","v","ksv","o","nuq","r","txhe","e","wmo","cehy","tskz","ds","kzbu"});
        assertThat(actual).isEqualTo(7);
    }

    // e NO
    //
    // collo
    //
    // y NO
    //
    // collo
    //
    // tkvz
    //
    // qpdau
    //
    // muqgs

    @Test
    public void test3() {
        var actual = solution.minExtraChar("ecolloycollotkvzqpdaumuqgs", new String[] {
                "flbri","uaaz","numy","laper","ioqyt","tkvz","ndjb","gmg","gdpbo","x","collo","vuh","qhozp","iwk","paqgn",
                "m","mhx","jgren","qqshd","qr","qpdau","oeeuq","c","qkot","uxqvx","lhgid","vchsk","drqx","keaua","yaru",
                "mla","shz","lby","vdxlv","xyai","lxtgl","inz","brhi","iukt","f","lbjou","vb","sz","ilkra","izwk","muqgs",
                "gom","je"});
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test4() {
        var actual = solution.minExtraChar("octncmdbgnxapjoqlofuzypthlytkmchayflwky", new String[] {
                "m","its","imaby","pa","ijmnvj","k","mhka","n","y","nc","wq","p","mjqqa","ht","dfoa","yqa","kk","pixq",
                "ixsdln","rh","dwl","dbgnxa","kmpfz","nhxjm","wg","wky","oct","og","uhin","zxb","qz","tpf","hlrc","j",
                "l","tew","xbn","a","uzypt","uvln","mchay","onnbi","hlytk","pjoqlo","dxsjr","u","uj"});
        assertThat(actual).isEqualTo(2);
    }



    // metzeaencgpgvsckjrqafkxgyzbe

    // m - 1
    // e - 2
    // t - 2     tze: found
    // z - 2
    // e - 2
    // a - 2     ae: found OR a: skip AND encgp: found
    // e - 2


    @Test
    public void test5() {
        var actual = solution.minExtraChar("metzeaencgpgvsckjrqafkxgyzbe", new String[]{
                "zdzz", "lgrhy", "r", "ohk", "zkowk", "g", "zqpn", "anoni", "ka", "qafkx", "t", "jr", "xdye", "mppc", "bqqb", "encgp",
                "yf", "vl", "ctsxk", "gn", "cujh", "ce", "rwrpq", "tze", "zxhg", "yzbe", "c", "o", "hnk", "gv", "uzbc", "xn", "kk", "ujjd",
                "vv", "mxhmv", "ugn", "at", "kumr", "ensv", "x", "uy", "gb", "ae", "jljuo", "xqkgj"});
        assertThat(actual).isEqualTo(5);
    }

    @Test
    public void test51() {
        var actual = solution.minExtraChar("tzeaencgp", new String[]{
                "tze", "ae", "encgp"});
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test6() {
        var actual = solution.minExtraChar("gjkeqjqagyrjwwviwsmvreqwsmjxkkmqagyrjbzmmwzmkkzw", new String[]{
                "fhv", "k", "for", "evgl", "zaf", "r", "zm", "wwv", "qagyrj", "fdqrza", "re", "z", "m", "btakty", "wsm", "tnmqsg", "jxkkm", "tq", "jkeqj", "mh", "nlhabu", "ateihv"});
        assertThat(actual).isEqualTo(7);
    }

    @Test
    public void test2026() {
        var actual = solution.minExtraChar("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", new String[]{
                "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa", "aaaaaaaaaaa", "aaaaaaaaaaaa", "aaaaaaaaaaaaa",
                "aaaaaaaaaaaaaa", "aaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"});
        assertThat(actual).isEqualTo(0);
    }
}