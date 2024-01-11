package com.mygaienko.common.algorithms.leetcode.brace_expansion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

class SolutionV2 {

    // iterate over string
    // keep all current string in queue with string builders
    // while facing curly brace - { extract all the options to list and sort
    // poll all the strings from queue and multiple on options, and offer back to queue
    public String[] expand(String s) {
        var queue = new ArrayDeque<StringBuilder>();
        for (int i = 0; i < s.length(); i++) {
            var ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                if (queue.isEmpty()) {
                    var sb = new StringBuilder();
                    sb.append(ch);
                    queue.offer(sb);
                } else {
                    for (var sb : queue) {
                        sb.append(ch);
                    }
                }
            } else if (ch == '{') {
                i++;
                var options = new ArrayList<Character>();
                while (s.charAt(i) != '}') {
                    if (Character.isLetter(s.charAt(i))) {
                        options.add(s.charAt(i));
                    }
                    i++;
                }
                Collections.sort(options);
                if (queue.isEmpty()) {
                    for (var option : options) {
                        var sb = new StringBuilder();
                        sb.append(option);
                        queue.offer(sb);
                    }
                    continue;
                }

                var nextQueue = new ArrayDeque<StringBuilder>();
                while (!queue.isEmpty()) {
                    var next = queue.poll();
                    for (var option : options) {
                        var sb = new StringBuilder(next);
                        sb.append(option);
                        nextQueue.offer(sb);
                    }
                }
                queue = nextQueue;
            }
        }

        var result = new String[queue.size()];
        var length = queue.size();
        for (int i = 0; i < length; i++) {
            result[i] = queue.poll().toString();
        }

        return result;
    }


}