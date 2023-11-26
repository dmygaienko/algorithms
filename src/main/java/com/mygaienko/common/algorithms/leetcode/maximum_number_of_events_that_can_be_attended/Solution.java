package com.mygaienko.common.algorithms.leetcode.maximum_number_of_events_that_can_be_attended;

import java.util.BitSet;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    public int maxEvents(int[][] events) {
        var longEventsQueue = new PriorityQueue<Integer>(Comparator.comparingInt(i -> events[i][0]));
        var shortEventsQueue = new PriorityQueue<Integer>(Comparator.comparingInt(i -> events[i][1]));
        var seen = new BitSet(events.length);

        var min = Integer.MAX_VALUE;
        var max = Integer.MIN_VALUE;
        for (int i = 0; i < events.length; i++) {
            var event = events[i];
            shortEventsQueue.offer(i);
            longEventsQueue.offer(i);
            min = Math.min(min, event[0]);
            max = Math.max(max, event[1]);
        }

        var count = 0;
        var day = min;

        while (day <= max && (!shortEventsQueue.isEmpty() || !longEventsQueue.isEmpty())) {
            int next;

            if (shortEventsQueue.isEmpty()) {
                next = longEventsQueue.poll();
                seen.set(next);
                count++;
            } else if (longEventsQueue.isEmpty()) {
                next = shortEventsQueue.poll();
                seen.set(next);
                count++;
            } else if (events[shortEventsQueue.peek()][0] <= day && day <= events[shortEventsQueue.peek()][1]) {
                next = shortEventsQueue.poll();
                seen.set(next);
                count++;
            } else if (events[longEventsQueue.peek()][0] <= day && day <= events[longEventsQueue.peek()][1]) {
                next = longEventsQueue.poll();
                seen.set(next);
                count++;
            } else if (events[shortEventsQueue.peek()][1] < day && day > events[longEventsQueue.peek()][1]) {
                next = longEventsQueue.poll();
                seen.set(next);
                day--;
            }

            while (!shortEventsQueue.isEmpty() && seen.get(shortEventsQueue.peek())) {
                shortEventsQueue.poll();
            }

            while (!longEventsQueue.isEmpty() && seen.get(longEventsQueue.peek())) {
                longEventsQueue.poll();
            }

            day++;
        }

        return count;
    }
}


// Sort + PriorityQueue Solution
// 1. Sort events by start day
// 2. Store end days of in progress events in min heap
// 3. Join the earliest ending in progress evetns from the earliest start event to the latest start evetn.
//    1) Get current date
//    2) Add just started events at current day in the min heap
//    3) Join the earliest ending event
//    4) Remove already ended events
// 4. Do the loop until we explore all the events and the min heap is empty.
// Time complexity: O(NlogN)
// Space complexity: O(N)
/*
class Solution {
    public int maxEvents(int[][] events) {
        if (events == null || events.length == 0) return 0;
        final int N = events.length;
        // Sort events by start day.
        Arrays.sort(events, (e1, e2) -> Integer.compare(e1[0], e2[0]));
        // Store end days of in progress events in min heap.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Join the earliest ending in progress evetns from the earliest start event to the latest start event.
        int i = 0, day = 0, res = 0;
        while (i < N || !pq.isEmpty()) {
            // Get current date.
            if (pq.isEmpty()) {
                day = events[i][0];
            }
            // Add just started events at current day in the min heap.
            while (i < N && day == events[i][0]) {
                pq.add(events[i][1]);
                i++;
            }
            // Join the earliest ending event.
            pq.poll();
            res++;
            day++;
            // Remove already ended events.
            while (!pq.isEmpty() && day > pq.peek()) {
                pq.poll();
            }
        }
        return res;
    }
}
*/
