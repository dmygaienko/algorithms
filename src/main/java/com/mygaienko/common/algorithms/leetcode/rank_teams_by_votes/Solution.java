package com.mygaienko.common.algorithms.leetcode.rank_teams_by_votes;

import java.util.PriorityQueue;

class Solution {
    public String rankTeams(String[] votes) {
        var points = new TeamVotes[26];

        for (var vote : votes) {
            var chars = vote.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                var nextCh = chars[i];
                var index = nextCh - 'A';

                if (points[index] == null) {
                    points[index] = new TeamVotes(index, i, chars.length);
                } else {
                    points[index].votes[i]++;
                }
            }
        }

        var queue = new PriorityQueue<TeamVotes>();
        for (TeamVotes point : points) {
            if (point != null) {
                queue.offer(point);
            }
        }

        var sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append((char) (queue.poll().index + 'A'));
        }

        return sb.toString();
    }

    public static class TeamVotes implements Comparable<TeamVotes> {
        int index;
        int[] votes;

        public TeamVotes(int index, int pos, int length) {
            this.index = index;
            this.votes = new int[length];
            this.votes[pos] = 1;
        }

        @Override
        public int compareTo(TeamVotes that) {
            int i = 0;
            while (i < this.votes.length && this.votes[i] == that.votes[i]) {
                i++;
            }
            return i == this.votes.length ? this.index - that.index : that.votes[i] - this.votes[i];
        }
    }
}