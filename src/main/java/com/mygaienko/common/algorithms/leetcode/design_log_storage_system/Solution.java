package com.mygaienko.common.algorithms.leetcode.design_log_storage_system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


class LogSystem {

    TreeMap<Long, Integer> map = new TreeMap<>();

    public LogSystem() {

    }

    public void put(int id, String timestamp) {
        var seconds = toSeconds(toIntArray(split(timestamp)));
        map.put(seconds, id);
    }

    public List<Integer> retrieve(String start, String end, String granularity) {
        var from = granularity(start, granularity, false);
        var to = granularity(end, granularity, true);

        var result = new ArrayList<Integer>();
        for (var entry : map.tailMap(from, true).entrySet()) {
            if (entry.getKey() >= to) {
                break;
            }
            result.add(entry.getValue());
        }
        return result;
    }

    private Long granularity(String timestamp, String granularity, boolean to) {
        var granularities = Map.of(
                "Year", 0,
                "Month", 1,
                "Day", 2,
                "Hour", 3,
                "Minute", 4,
                "Second", 5
        );
        var split = split(timestamp);
        String[] pattern = new String[]{"1999", "00", "00", "00", "00", "00"};
        for (int i = 0; i <= granularities.get(granularity); i++) {
            pattern[i] = split[i];
        }
        int[] t = toIntArray(pattern);
        if (to) {
            t[granularities.get(granularity)]++;
        }
        return toSeconds(t);
    }

    private static String[] split(String timestamp) {
        return timestamp.split(":");
    }

    private static int[] toIntArray(String[] pattern) {
        return Arrays.stream(pattern).mapToInt(Integer::parseInt).toArray();
    }

    private Long toSeconds(int[] splitTs) {
        splitTs[1] = splitTs[1] - (splitTs[1] == 0 ? 0 : 1);
        splitTs[2] = splitTs[2] - (splitTs[2] == 0 ? 0 : 1);

        var result = 0L;

        result += (long) (splitTs[0] - 1999) * (31 * 12) * 24 * 60 * 60;
        result += (long) splitTs[1] * 31 * 24 * 60 * 60;
        result += (long) splitTs[2] * 24 * 60 * 60;
        result += (long) splitTs[3] * 60 * 60;
        result += (long) splitTs[4] * 60;
        result += (long) splitTs[5];

        return result;
    }
}