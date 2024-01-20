package com.mygaienko.common.algorithms.leetcode.generate_abbreviations;

import java.util.ArrayList;
import java.util.List;

class Solution {

    // iterate over chars
    // for each subchar create substring and replace with abbreviation and go further
    public List<String> generateAbbreviations(String word) {
        var result = new ArrayList<String>();
        generate(word, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void generate(String word, int index, int abbreviatedCount, StringBuilder sb, List<String> result) {
        var prevLength = sb.length();
        if (index == word.length()) {
            if (abbreviatedCount != 0) {
                sb.append(abbreviatedCount);
            }
            result.add(sb.toString());
            sb.setLength(prevLength);
            return;
        }

        //branch that word.charAt(i) abbreviated
        generate(word, index + 1, abbreviatedCount + 1, sb, result);

        //branch that word.charAt(i) is kept
        if (abbreviatedCount != 0) {
            sb.append(abbreviatedCount);
        }
        sb.append(word.charAt(index));
        generate(word, index + 1, 0, sb, result);
        sb.setLength(prevLength);
    }
}