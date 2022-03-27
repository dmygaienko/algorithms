package com.mygaienko.common.algorithms.leetcode.expressive_words;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int expressiveWords(String s, String[] words) {
        List<CharGroup> stringGroups = toStringGroups(s);

        int result = 0;
        for (String word : words) {
            char[] chars = word.toCharArray();

            int j = 0;

            int currentGroup = 0;
            for (int i = 0; i < chars.length; i++) {
                char ch = chars[i];
                CharGroup charGroup = stringGroups.get(j);

                if (i >= chars.length - 1 || chars[i+1] != ch) {
                    if (ch == charGroup.getChar() &&
                            (charGroup.getCount() == currentGroup + 1 ||
                            charGroup.getCount() > currentGroup && charGroup.getCount() > 2)) {

                        if (j < stringGroups.size() - 1) {
                            j++;
                            currentGroup = 0;
                        } else if (i == chars.length - 1 && j + 1 != stringGroups.size()) {
                            break;
                        } else if (i < chars.length - 1){ // chars not equals and still a lot of chars in tested string
                            break;
                        } else { // last char was successful
                            result++;
                        }
                    } else { // not expressive
                       break;
                    }
                } else if (ch == charGroup.getChar()) {
                    currentGroup++;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    private List<CharGroup> toStringGroups(String s) {
        char[] chars = s.toCharArray();
        List<CharGroup> stringGroups = new ArrayList<>();

        CharGroup charGroup = null;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (charGroup == null) {
                charGroup = new CharGroup(c);
            } else if (c == charGroup.getChar()) {
                charGroup.increase();
            } else {
                stringGroups.add(charGroup); // add for prev char
                charGroup = new CharGroup(c);
            }

            if (i == chars.length - 1) {
                stringGroups.add(charGroup);
            }
        }

        return stringGroups;
    }

    static class CharGroup {

        private char ch;
        private int count;

        public CharGroup(char ch) {
            this(ch, 1);
        }

        public CharGroup(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        public char getChar() {
            return ch;
        }

        public int getCount() {
            return count;
        }

        public void increase() {
            this.count = count + 1;
        }
    }
}
