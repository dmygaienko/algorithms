package com.mygaienko.common.algorithms.leetcode.text_justification;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> results = new ArrayList<>();

        List<String> line = new ArrayList<>();
        int lineSize = 0;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (lineSize + word.length() < maxWidth) {
                line.add(word);
                lineSize = lineSize + word.length() + 1;

                if (i == words.length - 1) {
                    int diff = maxWidth - (lineSize-1);
                    results.add(buildLastLine(line, diff));
                }
            } else if (lineSize + word.length() == maxWidth) {
                line.add(word);
                results.add(buildLineEvenly(line, 1, 0, line.size() - 1));
                line = new ArrayList<>();
                lineSize = 0;
            } else {
                int extra = 0;
                int remainder = 0;
                int diff = maxWidth - (lineSize - line.size());

                if (diff > 0 && line.size() > 1) {
                    extra = diff / (line.size() - 1);
                    remainder = diff % (line.size() - 1);
                }

                results.add(buildLineEvenly(line, extra, remainder, diff));

                line = new ArrayList<>();
                line.add(word);
                lineSize = word.length() + 1;

                if (i == words.length - 1) {
                    diff = maxWidth - (lineSize-1);
                    results.add(buildLastLine(line, diff));
                }
            }

        }

        return results;
    }

    public String buildLastLine(List<String> line, int diff) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < line.size(); i++) {
            String w = line.get(i);
            stringBuilder.append(w);
            if (i < line.size() -1) {
                stringBuilder.append(" ");
            }
        }
        stringBuilder.append(buildExtra(diff));
        return stringBuilder.toString();
    }

    public String buildLineEvenly(List<String> line, int extra, int remainder, int diff) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < line.size(); i++) {
            String w = line.get(i);

            stringBuilder.append(w);

            if (diff - extra >= 0) {
                int curExtra = extra;

                if (remainder > 0) {
                    ++curExtra;
                    --remainder;
                }

                diff = diff - curExtra;
                stringBuilder.append(buildExtra(curExtra != 0 ? curExtra : diff));
            }
        }
        return stringBuilder.toString();
    }

    private String buildExtra(int curExtra) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < curExtra; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

}
