package com.mygaienko.common.algorithms.leetcode.logger_rate_limiter;

import java.util.HashMap;
import java.util.Map;

class Logger {

    Map<String, Integer> logAllowed = new HashMap<>();

    public Logger() {

    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        var nextTime = logAllowed.getOrDefault(message, timestamp);

        var allowed = nextTime <= timestamp;
        if (allowed) {
            logAllowed.put(message, timestamp + 10);
        }

        return allowed;
    }

}