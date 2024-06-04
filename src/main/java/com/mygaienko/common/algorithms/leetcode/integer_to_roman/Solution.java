package com.mygaienko.common.algorithms.leetcode.integer_to_roman;

class Solution {
    public String intToRoman(int num) {
        var roman = new StringBuilder();

        var remainder = num;
        while (remainder > 0) {
            if (remainder >= 1000) {
                roman.append('M');
                remainder -= 1000;
            } else if (remainder >= 900) {
                roman.append("CM");
                remainder -= 900;
            } else if (remainder >= 500) {
                roman.append('D');
                remainder -= 500;
            } else if (remainder >= 400) {
                roman.append("CD");
                remainder -= 400;
            } else if (remainder >= 100) {
                roman.append('C');
                remainder -= 100;
            } else if (remainder >= 90) {
                roman.append("XC");
                remainder -= 90;
            } else if (remainder >= 50) {
                roman.append('L');
                remainder -= 50;
            } else if (remainder >= 40) {
                roman.append("XL");
                remainder -= 40;
            } else if (remainder >= 10) {
                roman.append('X');
                remainder -= 10;
            } else if (remainder >= 9) {
                roman.append("IX");
                remainder -= 9;
            } else if (remainder >= 5) {
                roman.append('V');
                remainder -= 5;
            } else if (remainder >= 4) {
                roman.append("IV");
                remainder -= 4;
            } else { // if (remainder >= 1)
                roman.append('I');
                remainder -= 1;
            }
        }

        return roman.toString();
    }
}
