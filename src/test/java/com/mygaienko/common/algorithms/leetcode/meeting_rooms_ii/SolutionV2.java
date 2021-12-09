package com.mygaienko.common.algorithms.leetcode.meeting_rooms_ii;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

class SolutionV2 {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int maxRooms = 0;
        PriorityQueue<Room> rooms = new PriorityQueue<>(Comparator.comparingInt(Room::getEnd));

        for (int i = 0; i < intervals.length; i++) {
            int[] fromTo = intervals[i];
            int start = fromTo[0];
            int end = fromTo[1];

            Room nextRoom = rooms.peek();

            if (nextRoom != null && nextRoom.end <= start) {
                rooms.remove(nextRoom);
                nextRoom.end = end;
            } else {
                nextRoom = new Room(end);
            }

            rooms.add(nextRoom);
            maxRooms = Math.max(maxRooms, rooms.size());
        }

        return maxRooms;
    }

    static class Room {
        int end = -1;

        public Room(int end) {
            this.end = end;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Room room = (Room) o;
            return end == room.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(end);
        }
    }

}
