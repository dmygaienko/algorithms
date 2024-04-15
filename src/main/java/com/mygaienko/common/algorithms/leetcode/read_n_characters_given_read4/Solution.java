package com.mygaienko.common.algorithms.leetcode.read_n_characters_given_read4;

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int result = 0;

        var cache = new char[4];
        var toRead = n;
        while (toRead > 0) {

            var read = read4(cache);
            var actualRead = Math.min(toRead, read);
            result += actualRead;

            if (read == 0) {
                return result;
            } else {
                System.arraycopy(cache, 0, buf, n - toRead, actualRead);
            }
            toRead -= read;
        }

        return result;
    }
}

abstract class Reader4 {
    public int read4(char[] buf4) {
        buf4[0] = 'a';
        buf4[1] = 'b';
        buf4[2] = 'c';
        buf4[3] = 'd';
        return 4;
    }
}