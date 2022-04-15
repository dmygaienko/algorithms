package com.mygaienko.common.algorithms.leetcode.backspace_string_compare;

class Solution {

    private static final char BSP = '#';

    public boolean backspaceCompare(String s, String t) {
        char[] a1 = s.toCharArray();
        char[] a2 = t.toCharArray();

        int i1 = a1.length - 1;
        int i2 = a2.length - 1;

        int bsp1 = 0;
        int bsp2 = 0;

        char ch1 = '`';
        char ch2 = '`';
        while (i1 >= 0 || i2 >=0) {

            if (i1 >= 0) {
                ch1 = a1[i1];

                if (ch1 == BSP) {
                    i1--; bsp1++;
                    continue;
                } else if (bsp1 > 0) {
                    i1--; bsp1--;
                    continue;
                }
            }

            if (i2 >= 0) {
                ch2 = a2[i2];

                if (ch2 == BSP) {
                    i2--; bsp2++;
                    continue;
                } else if (bsp2 > 0){
                    i2--; bsp2--;
                    continue;
                }
            }

            if (ch1 != ch2) return false;
            i1--;
            i2--;
        }

        return i1 == i2;
    }
}
