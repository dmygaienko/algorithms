package com.mygaienko.common.algorithms.leetcode.reconstruct_itinerary;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * eulerian circuit
 */
class Solution {

    private static final String START = "JFK";

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            adj.computeIfAbsent(from, (v) -> new PriorityQueue<>()).offer(to);
        }

        List<String> result = new ArrayList<>();
        Deque<String> itinerary = findItinerary(adj, START);
        while (!itinerary.isEmpty()) {
            result.add(itinerary.pop());
        }
        return result;
    }

    private Deque<String> findItinerary(Map<String, PriorityQueue<String>> adj, String airport) {
        Deque<String> stack = new ArrayDeque<>();
        PriorityQueue<String> airPortAdj = adj.get(airport);
        if (airPortAdj == null || airPortAdj.isEmpty()) {
            stack.push(airport);
            return stack;
        }

        while (!airPortAdj.isEmpty()) {
            String next = airPortAdj.poll();
            Deque<String> itinerary = findItinerary(adj, next);
            if (!itinerary.isEmpty()) {
                if (airPortAdj.isEmpty()) {
                    itinerary.push(airport);
                }
                while (!itinerary.isEmpty()) {
                   stack.push(itinerary.pollLast());
                }
            }
        }

        return stack;
    }
}
