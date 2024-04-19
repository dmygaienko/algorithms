package com.mygaienko.common.algorithms.leetcode.design_compressed_string_iterator;

public class StringIteratorV2 {

    int index = 0;

    int count = 0;

    char ch = ' ';

    String str;

    public StringIteratorV2(String compressedString) {
        str = compressedString;
    }

    public char next() {
        if (!hasNext()) return ' ';

        if (count == 0) {
            ch = str.charAt(index);
            index++;

            while (index < str.length() && Character.isDigit(str.charAt(index))) {
                count = count * 10 + (str.charAt(index) - '0');
                index++;
            }
        }
        count--;
        return ch;
    }

    public boolean hasNext() {
        return index < str.length() || count != 0;
    }
}
