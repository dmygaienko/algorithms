package com.mygaienko.common.algorithms.leetcode.generate_abbreviations;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.generateAbbreviations("a");
        assertThat(actual).containsExactlyInAnyOrder("1", "a");
    }

    @Test
    public void test1() {
        var actual = solution.generateAbbreviations("word");
        assertThat(actual).containsExactlyInAnyOrder("4", "3d", "2r1", "2rd", "1o2", "1o1d", "1or1", "1ord", "w3", "w2d", "w1r1", "w1rd", "wo2", "wo1d", "wor1", "word");
    }


    @Test
    public void test2() {
        var actual = solution.generateAbbreviations("dictionary");
        assertThat(actual).containsExactlyInAnyOrder("10", "9y", "8r1", "8ry", "7a2", "7a1y", "7ar1", "7ary", "6n3", "6n2y", "6n1r1", "6n1ry", "6na2", "6na1y", "6nar1", "6nary", "5o4", "5o3y", "5o2r1", "5o2ry", "5o1a2", "5o1a1y", "5o1ar1", "5o1ary", "5on3", "5on2y", "5on1r1", "5on1ry", "5ona2", "5ona1y", "5onar1", "5onary", "4i5", "4i4y", "4i3r1", "4i3ry", "4i2a2", "4i2a1y", "4i2ar1", "4i2ary", "4i1n3", "4i1n2y", "4i1n1r1", "4i1n1ry", "4i1na2", "4i1na1y", "4i1nar1", "4i1nary", "4io4", "4io3y", "4io2r1", "4io2ry", "4io1a2", "4io1a1y", "4io1ar1", "4io1ary", "4ion3", "4ion2y", "4ion1r1", "4ion1ry", "4iona2", "4iona1y", "4ionar1", "4ionary", "3t6", "3t5y", "3t4r1", "3t4ry", "3t3a2", "3t3a1y", "3t3ar1", "3t3ary", "3t2n3", "3t2n2y", "3t2n1r1", "3t2n1ry", "3t2na2", "3t2na1y", "3t2nar1", "3t2nary", "3t1o4", "3t1o3y", "3t1o2r1", "3t1o2ry", "3t1o1a2", "3t1o1a1y", "3t1o1ar1", "3t1o1ary", "3t1on3", "3t1on2y", "3t1on1r1", "3t1on1ry", "3t1ona2", "3t1ona1y", "3t1onar1", "3t1onary", "3ti5", "3ti4y", "3ti3r1", "3ti3ry", "3ti2a2", "3ti2a1y", "3ti2ar1", "3ti2ary", "3ti1n3", "3ti1n2y", "3ti1n1r1", "3ti1n1ry", "3ti1na2", "3ti1na1y", "3ti1nar1", "3ti1nary", "3tio4", "3tio3y", "3tio2r1", "3tio2ry", "3tio1a2", "3tio1a1y", "3tio1ar1", "3tio1ary", "3tion3", "3tion2y", "3tion1r1", "3tion1ry", "3tiona2", "3tiona1y", "3tionar1", "3tionary", "2c7", "2c6y", "2c5r1", "2c5ry", "2c4a2", "2c4a1y", "2c4ar1", "2c4ary", "2c3n3", "2c3n2y", "2c3n1r1", "2c3n1ry", "2c3na2", "2c3na1y", "2c3nar1", "2c3nary", "2c2o4", "2c2o3y", "2c2o2r1", "2c2o2ry", "2c2o1a2", "2c2o1a1y", "2c2o1ar1", "2c2o1ary", "2c2on3", "2c2on2y", "2c2on1r1", "2c2on1ry", "2c2ona2", "2c2ona1y", "2c2onar1", "2c2onary", "2c1i5", "2c1i4y", "2c1i3r1", "2c1i3ry", "2c1i2a2", "2c1i2a1y", "2c1i2ar1", "2c1i2ary", "2c1i1n3", "2c1i1n2y", "2c1i1n1r1", "2c1i1n1ry", "2c1i1na2", "2c1i1na1y", "2c1i1nar1", "2c1i1nary", "2c1io4", "2c1io3y", "2c1io2r1", "2c1io2ry", "2c1io1a2", "2c1io1a1y", "2c1io1ar1", "2c1io1ary", "2c1ion3", "2c1ion2y", "2c1ion1r1", "2c1ion1ry", "2c1iona2", "2c1iona1y", "2c1ionar1", "2c1ionary", "2ct6", "2ct5y", "2ct4r1", "2ct4ry", "2ct3a2", "2ct3a1y", "2ct3ar1", "2ct3ary", "2ct2n3", "2ct2n2y", "2ct2n1r1", "2ct2n1ry", "2ct2na2", "2ct2na1y", "2ct2nar1", "2ct2nary", "2ct1o4", "2ct1o3y", "2ct1o2r1", "2ct1o2ry", "2ct1o1a2", "2ct1o1a1y", "2ct1o1ar1", "2ct1o1ary", "2ct1on3", "2ct1on2y", "2ct1on1r1", "2ct1on1ry", "2ct1ona2", "2ct1ona1y", "2ct1onar1", "2ct1onary", "2cti5", "2cti4y", "2cti3r1", "2cti3ry", "2cti2a2", "2cti2a1y", "2cti2ar1", "2cti2ary", "2cti1n3", "2cti1n2y", "2cti1n1r1", "2cti1n1ry", "2cti1na2", "2cti1na1y", "2cti1nar1", "2cti1nary", "2ctio4", "2ctio3y", "2ctio2r1", "2ctio2ry", "2ctio1a2", "2ctio1a1y", "2ctio1ar1", "2ctio1ary", "2ction3", "2ction2y", "2ction1r1", "2ction1ry", "2ctiona2", "2ctiona1y", "2ctionar1", "2ctionary", "1i8", "1i7y", "1i6r1", "1i6ry", "1i5a2", "1i5a1y", "1i5ar1", "1i5ary", "1i4n3", "1i4n2y", "1i4n1r1", "1i4n1ry", "1i4na2", "1i4na1y", "1i4nar1", "1i4nary", "1i3o4", "1i3o3y", "1i3o2r1", "1i3o2ry", "1i3o1a2", "1i3o1a1y", "1i3o1ar1", "1i3o1ary", "1i3on3", "1i3on2y", "1i3on1r1", "1i3on1ry", "1i3ona2", "1i3ona1y", "1i3onar1", "1i3onary", "1i2i5", "1i2i4y", "1i2i3r1", "1i2i3ry", "1i2i2a2", "1i2i2a1y", "1i2i2ar1", "1i2i2ary", "1i2i1n3", "1i2i1n2y", "1i2i1n1r1", "1i2i1n1ry", "1i2i1na2", "1i2i1na1y", "1i2i1nar1", "1i2i1nary", "1i2io4", "1i2io3y", "1i2io2r1", "1i2io2ry", "1i2io1a2", "1i2io1a1y", "1i2io1ar1", "1i2io1ary", "1i2ion3", "1i2ion2y", "1i2ion1r1", "1i2ion1ry", "1i2iona2", "1i2iona1y", "1i2ionar1", "1i2ionary", "1i1t6", "1i1t5y", "1i1t4r1", "1i1t4ry", "1i1t3a2", "1i1t3a1y", "1i1t3ar1", "1i1t3ary", "1i1t2n3", "1i1t2n2y", "1i1t2n1r1", "1i1t2n1ry", "1i1t2na2", "1i1t2na1y", "1i1t2nar1", "1i1t2nary", "1i1t1o4", "1i1t1o3y", "1i1t1o2r1", "1i1t1o2ry", "1i1t1o1a2", "1i1t1o1a1y", "1i1t1o1ar1", "1i1t1o1ary", "1i1t1on3", "1i1t1on2y", "1i1t1on1r1", "1i1t1on1ry", "1i1t1ona2", "1i1t1ona1y", "1i1t1onar1", "1i1t1onary", "1i1ti5", "1i1ti4y", "1i1ti3r1", "1i1ti3ry", "1i1ti2a2", "1i1ti2a1y", "1i1ti2ar1", "1i1ti2ary", "1i1ti1n3", "1i1ti1n2y", "1i1ti1n1r1", "1i1ti1n1ry", "1i1ti1na2", "1i1ti1na1y", "1i1ti1nar1", "1i1ti1nary", "1i1tio4", "1i1tio3y", "1i1tio2r1", "1i1tio2ry", "1i1tio1a2", "1i1tio1a1y", "1i1tio1ar1", "1i1tio1ary", "1i1tion3", "1i1tion2y", "1i1tion1r1", "1i1tion1ry", "1i1tiona2", "1i1tiona1y", "1i1tionar1", "1i1tionary", "1ic7", "1ic6y", "1ic5r1", "1ic5ry", "1ic4a2", "1ic4a1y", "1ic4ar1", "1ic4ary", "1ic3n3", "1ic3n2y", "1ic3n1r1", "1ic3n1ry", "1ic3na2", "1ic3na1y", "1ic3nar1", "1ic3nary", "1ic2o4", "1ic2o3y", "1ic2o2r1", "1ic2o2ry", "1ic2o1a2", "1ic2o1a1y", "1ic2o1ar1", "1ic2o1ary", "1ic2on3", "1ic2on2y", "1ic2on1r1", "1ic2on1ry", "1ic2ona2", "1ic2ona1y", "1ic2onar1", "1ic2onary", "1ic1i5", "1ic1i4y", "1ic1i3r1", "1ic1i3ry", "1ic1i2a2", "1ic1i2a1y", "1ic1i2ar1", "1ic1i2ary", "1ic1i1n3", "1ic1i1n2y", "1ic1i1n1r1", "1ic1i1n1ry", "1ic1i1na2", "1ic1i1na1y", "1ic1i1nar1", "1ic1i1nary", "1ic1io4", "1ic1io3y", "1ic1io2r1", "1ic1io2ry", "1ic1io1a2", "1ic1io1a1y", "1ic1io1ar1", "1ic1io1ary", "1ic1ion3", "1ic1ion2y", "1ic1ion1r1", "1ic1ion1ry", "1ic1iona2", "1ic1iona1y", "1ic1ionar1", "1ic1ionary", "1ict6", "1ict5y", "1ict4r1", "1ict4ry", "1ict3a2", "1ict3a1y", "1ict3ar1", "1ict3ary", "1ict2n3", "1ict2n2y", "1ict2n1r1", "1ict2n1ry", "1ict2na2", "1ict2na1y", "1ict2nar1", "1ict2nary", "1ict1o4", "1ict1o3y", "1ict1o2r1", "1ict1o2ry", "1ict1o1a2", "1ict1o1a1y", "1ict1o1ar1", "1ict1o1ary", "1ict1on3", "1ict1on2y", "1ict1on1r1", "1ict1on1ry", "1ict1ona2", "1ict1ona1y", "1ict1onar1", "1ict1onary", "1icti5", "1icti4y", "1icti3r1", "1icti3ry", "1icti2a2", "1icti2a1y", "1icti2ar1", "1icti2ary", "1icti1n3", "1icti1n2y", "1icti1n1r1", "1icti1n1ry", "1icti1na2", "1icti1na1y", "1icti1nar1", "1icti1nary", "1ictio4", "1ictio3y", "1ictio2r1", "1ictio2ry", "1ictio1a2", "1ictio1a1y", "1ictio1ar1", "1ictio1ary", "1iction3", "1iction2y", "1iction1r1", "1iction1ry", "1ictiona2", "1ictiona1y", "1ictionar1", "1ictionary", "d9", "d8y", "d7r1", "d7ry", "d6a2", "d6a1y", "d6ar1", "d6ary", "d5n3", "d5n2y", "d5n1r1", "d5n1ry", "d5na2", "d5na1y", "d5nar1", "d5nary", "d4o4", "d4o3y", "d4o2r1", "d4o2ry", "d4o1a2", "d4o1a1y", "d4o1ar1", "d4o1ary", "d4on3", "d4on2y", "d4on1r1", "d4on1ry", "d4ona2", "d4ona1y", "d4onar1", "d4onary", "d3i5", "d3i4y", "d3i3r1", "d3i3ry", "d3i2a2", "d3i2a1y", "d3i2ar1", "d3i2ary", "d3i1n3", "d3i1n2y", "d3i1n1r1", "d3i1n1ry", "d3i1na2", "d3i1na1y", "d3i1nar1", "d3i1nary", "d3io4", "d3io3y", "d3io2r1", "d3io2ry", "d3io1a2", "d3io1a1y", "d3io1ar1", "d3io1ary", "d3ion3", "d3ion2y", "d3ion1r1", "d3ion1ry", "d3iona2", "d3iona1y", "d3ionar1", "d3ionary", "d2t6", "d2t5y", "d2t4r1", "d2t4ry", "d2t3a2", "d2t3a1y", "d2t3ar1", "d2t3ary", "d2t2n3", "d2t2n2y", "d2t2n1r1", "d2t2n1ry", "d2t2na2", "d2t2na1y", "d2t2nar1", "d2t2nary", "d2t1o4", "d2t1o3y", "d2t1o2r1", "d2t1o2ry", "d2t1o1a2", "d2t1o1a1y", "d2t1o1ar1", "d2t1o1ary", "d2t1on3", "d2t1on2y", "d2t1on1r1", "d2t1on1ry", "d2t1ona2", "d2t1ona1y", "d2t1onar1", "d2t1onary", "d2ti5", "d2ti4y", "d2ti3r1", "d2ti3ry", "d2ti2a2", "d2ti2a1y", "d2ti2ar1", "d2ti2ary", "d2ti1n3", "d2ti1n2y", "d2ti1n1r1", "d2ti1n1ry", "d2ti1na2", "d2ti1na1y", "d2ti1nar1", "d2ti1nary", "d2tio4", "d2tio3y", "d2tio2r1", "d2tio2ry", "d2tio1a2", "d2tio1a1y", "d2tio1ar1", "d2tio1ary", "d2tion3", "d2tion2y", "d2tion1r1", "d2tion1ry", "d2tiona2", "d2tiona1y", "d2tionar1", "d2tionary", "d1c7", "d1c6y", "d1c5r1", "d1c5ry", "d1c4a2", "d1c4a1y", "d1c4ar1", "d1c4ary", "d1c3n3", "d1c3n2y", "d1c3n1r1", "d1c3n1ry", "d1c3na2", "d1c3na1y", "d1c3nar1", "d1c3nary", "d1c2o4", "d1c2o3y", "d1c2o2r1", "d1c2o2ry", "d1c2o1a2", "d1c2o1a1y", "d1c2o1ar1", "d1c2o1ary", "d1c2on3", "d1c2on2y", "d1c2on1r1", "d1c2on1ry", "d1c2ona2", "d1c2ona1y", "d1c2onar1", "d1c2onary", "d1c1i5", "d1c1i4y", "d1c1i3r1", "d1c1i3ry", "d1c1i2a2", "d1c1i2a1y", "d1c1i2ar1", "d1c1i2ary", "d1c1i1n3", "d1c1i1n2y", "d1c1i1n1r1", "d1c1i1n1ry", "d1c1i1na2", "d1c1i1na1y", "d1c1i1nar1", "d1c1i1nary", "d1c1io4", "d1c1io3y", "d1c1io2r1", "d1c1io2ry", "d1c1io1a2", "d1c1io1a1y", "d1c1io1ar1", "d1c1io1ary", "d1c1ion3", "d1c1ion2y", "d1c1ion1r1", "d1c1ion1ry", "d1c1iona2", "d1c1iona1y", "d1c1ionar1", "d1c1ionary", "d1ct6", "d1ct5y", "d1ct4r1", "d1ct4ry", "d1ct3a2", "d1ct3a1y", "d1ct3ar1", "d1ct3ary", "d1ct2n3", "d1ct2n2y", "d1ct2n1r1", "d1ct2n1ry", "d1ct2na2", "d1ct2na1y", "d1ct2nar1", "d1ct2nary", "d1ct1o4", "d1ct1o3y", "d1ct1o2r1", "d1ct1o2ry", "d1ct1o1a2", "d1ct1o1a1y", "d1ct1o1ar1", "d1ct1o1ary", "d1ct1on3", "d1ct1on2y", "d1ct1on1r1", "d1ct1on1ry", "d1ct1ona2", "d1ct1ona1y", "d1ct1onar1", "d1ct1onary", "d1cti5", "d1cti4y", "d1cti3r1", "d1cti3ry", "d1cti2a2", "d1cti2a1y", "d1cti2ar1", "d1cti2ary", "d1cti1n3", "d1cti1n2y", "d1cti1n1r1", "d1cti1n1ry", "d1cti1na2", "d1cti1na1y", "d1cti1nar1", "d1cti1nary", "d1ctio4", "d1ctio3y", "d1ctio2r1", "d1ctio2ry", "d1ctio1a2", "d1ctio1a1y", "d1ctio1ar1", "d1ctio1ary", "d1ction3", "d1ction2y", "d1ction1r1", "d1ction1ry", "d1ctiona2", "d1ctiona1y", "d1ctionar1", "d1ctionary", "di8", "di7y", "di6r1", "di6ry", "di5a2", "di5a1y", "di5ar1", "di5ary", "di4n3", "di4n2y", "di4n1r1", "di4n1ry", "di4na2", "di4na1y", "di4nar1", "di4nary", "di3o4", "di3o3y", "di3o2r1", "di3o2ry", "di3o1a2", "di3o1a1y", "di3o1ar1", "di3o1ary", "di3on3", "di3on2y", "di3on1r1", "di3on1ry", "di3ona2", "di3ona1y", "di3onar1", "di3onary", "di2i5", "di2i4y", "di2i3r1", "di2i3ry", "di2i2a2", "di2i2a1y", "di2i2ar1", "di2i2ary", "di2i1n3", "di2i1n2y", "di2i1n1r1", "di2i1n1ry", "di2i1na2", "di2i1na1y", "di2i1nar1", "di2i1nary", "di2io4", "di2io3y", "di2io2r1", "di2io2ry", "di2io1a2", "di2io1a1y", "di2io1ar1", "di2io1ary", "di2ion3", "di2ion2y", "di2ion1r1", "di2ion1ry", "di2iona2", "di2iona1y", "di2ionar1", "di2ionary", "di1t6", "di1t5y", "di1t4r1", "di1t4ry", "di1t3a2", "di1t3a1y", "di1t3ar1", "di1t3ary", "di1t2n3", "di1t2n2y", "di1t2n1r1", "di1t2n1ry", "di1t2na2", "di1t2na1y", "di1t2nar1", "di1t2nary", "di1t1o4", "di1t1o3y", "di1t1o2r1", "di1t1o2ry", "di1t1o1a2", "di1t1o1a1y", "di1t1o1ar1", "di1t1o1ary", "di1t1on3", "di1t1on2y", "di1t1on1r1", "di1t1on1ry", "di1t1ona2", "di1t1ona1y", "di1t1onar1", "di1t1onary", "di1ti5", "di1ti4y", "di1ti3r1", "di1ti3ry", "di1ti2a2", "di1ti2a1y", "di1ti2ar1", "di1ti2ary", "di1ti1n3", "di1ti1n2y", "di1ti1n1r1", "di1ti1n1ry", "di1ti1na2", "di1ti1na1y", "di1ti1nar1", "di1ti1nary", "di1tio4", "di1tio3y", "di1tio2r1", "di1tio2ry", "di1tio1a2", "di1tio1a1y", "di1tio1ar1", "di1tio1ary", "di1tion3", "di1tion2y", "di1tion1r1", "di1tion1ry", "di1tiona2", "di1tiona1y", "di1tionar1", "di1tionary", "dic7", "dic6y", "dic5r1", "dic5ry", "dic4a2", "dic4a1y", "dic4ar1", "dic4ary", "dic3n3", "dic3n2y", "dic3n1r1", "dic3n1ry", "dic3na2", "dic3na1y", "dic3nar1", "dic3nary", "dic2o4", "dic2o3y", "dic2o2r1", "dic2o2ry", "dic2o1a2", "dic2o1a1y", "dic2o1ar1", "dic2o1ary", "dic2on3", "dic2on2y", "dic2on1r1", "dic2on1ry", "dic2ona2", "dic2ona1y", "dic2onar1", "dic2onary", "dic1i5", "dic1i4y", "dic1i3r1", "dic1i3ry", "dic1i2a2", "dic1i2a1y", "dic1i2ar1", "dic1i2ary", "dic1i1n3", "dic1i1n2y", "dic1i1n1r1", "dic1i1n1ry", "dic1i1na2", "dic1i1na1y", "dic1i1nar1", "dic1i1nary", "dic1io4", "dic1io3y", "dic1io2r1", "dic1io2ry", "dic1io1a2", "dic1io1a1y", "dic1io1ar1", "dic1io1ary", "dic1ion3", "dic1ion2y", "dic1ion1r1", "dic1ion1ry", "dic1iona2", "dic1iona1y", "dic1ionar1", "dic1ionary", "dict6", "dict5y", "dict4r1", "dict4ry", "dict3a2", "dict3a1y", "dict3ar1", "dict3ary", "dict2n3", "dict2n2y", "dict2n1r1", "dict2n1ry", "dict2na2", "dict2na1y", "dict2nar1", "dict2nary", "dict1o4", "dict1o3y", "dict1o2r1", "dict1o2ry", "dict1o1a2", "dict1o1a1y", "dict1o1ar1", "dict1o1ary", "dict1on3", "dict1on2y", "dict1on1r1", "dict1on1ry", "dict1ona2", "dict1ona1y", "dict1onar1", "dict1onary", "dicti5", "dicti4y", "dicti3r1", "dicti3ry", "dicti2a2", "dicti2a1y", "dicti2ar1", "dicti2ary", "dicti1n3", "dicti1n2y", "dicti1n1r1", "dicti1n1ry", "dicti1na2", "dicti1na1y", "dicti1nar1", "dicti1nary", "dictio4", "dictio3y", "dictio2r1", "dictio2ry", "dictio1a2", "dictio1a1y", "dictio1ar1", "dictio1ary", "diction3", "diction2y", "diction1r1", "diction1ry", "dictiona2", "dictiona1y", "dictionar1", "dictionary");
    }

}