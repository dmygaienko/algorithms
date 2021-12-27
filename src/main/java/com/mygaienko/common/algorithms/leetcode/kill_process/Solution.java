package com.mygaienko.common.algorithms.leetcode.kill_process;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Input: pid = [1,3,10,5], ppid = [3,0,5,3], kill = 5
 * Output: [5,10]
 */
class Solution {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> children = initChild(ppid);

        result.add(kill);
        findChildren(pid, children, kill, result);
        return result;
    }

    private Map<Integer, List<Integer>> initChild(List<Integer> ppid) {
        Map<Integer, List<Integer>> children = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            Integer value = ppid.get(i);
            children.putIfAbsent(value, new ArrayList<>());
            children.get(value).add(i);
        }
        return children;
    }

    private Collection<? extends Integer> findChildren(List<Integer> pid,
                                                       Map<Integer, List<Integer>> children,
                                                       int parentValue, List<Integer> result) {
        List<Integer> childIds = children.get(parentValue);
        if (childIds == null) return result;

        for (Integer childId : childIds) {
            int childValue = pid.get(childId);
            result.add(childValue);
            findChildren(pid, children, childValue, result);
        }
        return result;
    }
}
