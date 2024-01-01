package com.mygaienko.common.algorithms.leetcode.analyze_user_website_visit_pattern;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    // iterate over array
    // for each user put website visiting to map
    // where value is sorted set of indexes
    // while collecting user patters put to the global pattern set
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        var usersPatterns = new HashMap<String, List<Integer>>();
        for (int i = 0; i < username.length; i++) {
            var name = username[i];
            usersPatterns.computeIfAbsent(name, v -> new ArrayList<>()).add(i);
        }

        var patterns = new HashMap<List<String>, Set<String>>();
        for (var userEntry : usersPatterns.entrySet()) {
            var userPatterns = userEntry.getValue();
            userPatterns.sort(Comparator.comparing(i -> timestamp[i]));

            for (int i = 0; i + 2 < userPatterns.size(); i++) {
                var first = website[userPatterns.get(i)];
                for (int j = i + 1; j + 1 < userPatterns.size(); j++) {
                    var second = website[userPatterns.get(j)];
                    for (int k = j + 1; k < userPatterns.size(); k++) {
                        var third = website[userPatterns.get(k)];
                        var pattern = List.of(first, second, third);
                        patterns.computeIfAbsent(pattern, v -> new HashSet<>()).add(userEntry.getKey());
                    }
                }
            }
        }

        var max = Integer.MIN_VALUE;
        List<String> maxPattern = List.of();
        for (var entry : patterns.entrySet()) {
            if (entry.getValue().size() > max) {
                maxPattern = entry.getKey();
                max = entry.getValue().size();
            } else if (entry.getValue().size() == max && isGreater(maxPattern, entry.getKey())) {
                maxPattern = entry.getKey();
                max = entry.getValue().size();
            }
        }

        return maxPattern;
    }

    private boolean isGreater(Collection<String> a, Collection<String> b) {
        var iterA = a.iterator();
        var iterB = b.iterator();

        while (iterA.hasNext() && iterB.hasNext()) {
            var nextA = iterA.next();
            var nextB = iterB.next();

            var comp = nextA.compareTo(nextB);
            if (comp == 0) {
                continue;
            } else if (comp < 0) {
                return false;
            } else {
                return true;
            }
        }

        if (iterA.hasNext()) {
            return true;
        }

        return false;
    }

}