package com.mygaienko.common.algorithms.leetcode.decode_the_slanted_ciphertext;

class Solution {

    public String decodeCiphertext(String encodedText, int rows) {
        var rowLength = encodedText.length() / rows;
        var sb = new StringBuilder();

        for (int i = 0; i < rowLength; i++) {

            for (int j = i; j < encodedText.length(); j += rowLength + 1) {
                var next = encodedText.charAt(j);
                sb.append(next);
            }
        }

        return sb.toString().stripTrailing();
    }

}