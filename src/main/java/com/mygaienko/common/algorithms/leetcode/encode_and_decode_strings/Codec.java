package com.mygaienko.common.algorithms.leetcode.encode_and_decode_strings;

import java.util.ArrayList;
import java.util.List;

public class Codec {

    String SPLIT = "<<D>>";

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        var sb = new StringBuilder();
        for (var str : strs) {
            sb.append(str);
            sb.append(SPLIT);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        var splitted = s.split(SPLIT, -1);
        var result = new ArrayList<String>(splitted.length - 1);
        for (int i = 0; i < splitted.length - 1; i++) {
            var spl = splitted[i];
            result.add(spl);
        }
        return result;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));