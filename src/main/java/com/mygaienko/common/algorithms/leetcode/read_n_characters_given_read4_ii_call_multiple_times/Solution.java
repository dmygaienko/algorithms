package com.mygaienko.common.algorithms.leetcode.read_n_characters_given_read4_ii_call_multiple_times;

public class Solution extends Reader4 {

    private char[] buf4 = new char[4];
    private int buf4Index = -1;
    private int read = 0;

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int i = 0;

        for ( ; i < n; i++, buf4Index++, read--) {

            if (buf4Index== -1 || buf4Index > 3 || read == 0) {
                read = read4(buf4);
                if (read == 0) return i;
                buf4Index = 0;
                buf[i] = buf4[buf4Index];

            } else if (read > 0) {
                buf[i] = buf4[buf4Index];
            }

        }

        return i;
    }
}

abstract class Reader4 {
    int read4(char[] buf4) {
        buf4[0] = 'a';
        buf4[1] = 'b';
        buf4[2] = 'c';
        buf4[3] = 'd';
        return 4;
    }
}
