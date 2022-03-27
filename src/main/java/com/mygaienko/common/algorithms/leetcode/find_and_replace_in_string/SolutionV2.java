package com.mygaienko.common.algorithms.leetcode.find_and_replace_in_string;

import java.util.Map;
import java.util.TreeMap;

/**
 * 833. Find And Replace in String
 * https://leetcode.com/problems/find-and-replace-in-string/
 */
class SolutionV2 {

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();

        Map<Integer, SourceTarget> map = new TreeMap<>();
        for (int i = 0; i < indices.length; i++) {
            map.put(indices[i], new SourceTarget(sources[i], targets[i]));
        }

        int start = 0;
        for (Map.Entry<Integer, SourceTarget> entry : map.entrySet()) {
            int index = entry.getKey();

            String substring = s.substring(start, index);
            sb.append(substring);

            String source = entry.getValue().source;
            int sourceSize = source.length();
            String stringToReplace = s.substring(index, index + sourceSize);

            if (stringToReplace.equals(source)) {
                sb.append(entry.getValue().target);
            } else {
                sb.append(stringToReplace);
            }

            start = index + sourceSize;
        }

        String substring = s.substring(start);
        sb.append(substring);

        return sb.toString();
    }

    static class SourceTarget {
        private String source;
        private String target;

        public SourceTarget(String source, String target) {
            this.source = source;
            this.target = target;
        }
    }

}
