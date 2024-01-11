package com.mygaienko.common.algorithms.leetcode.brace_expansion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Solution {

    public String[] expand(String s) {

        var allOptions = getAllOptions(s);

        var result = new ArrayList<String>();

        expand(allOptions, new StringBuilder(), result);

        return result.toArray(new String[0]);
    }

    private void expand(List<List<Character>> allOptions, StringBuilder sb, ArrayList<String> result) {
        if (sb.length() == allOptions.size()) {
            result.add(sb.toString());
            return;
        }

        var options = allOptions.get(sb.length());
        for (var option : options) {
            sb.append(option);
            expand(allOptions, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private List<List<Character>> getAllOptions(String s) {
        var allOptions = new ArrayList<List<Character>>();
        for (int i = 0; i < s.length(); i++) {
            var options = new ArrayList<Character>();
            var ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                options.add(ch);
            } else if (ch == '{') {
                while (s.charAt(i) != '}') {
                    var nextCh = s.charAt(i);
                    if (Character.isLetter(nextCh)) {
                        options.add(nextCh);
                    }
                    i++;
                }
            }
            Collections.sort(options);
            allOptions.add(options);
        }
        return allOptions;
    }


}