package com.mygaienko.common.algorithms.leetcode.design_a_leaderboard;


import java.util.*;

class Leaderboard {

    private final TreeSet<Player> sortedSet = new TreeSet<>();
    private final Map<Integer, Player> map = new HashMap<>();

    public void addScore(int playerId, int score) {
        Player exist = map.get(playerId);
        if (exist == null) {
            Player newPlayer = new Player(playerId, score);
            map.put(playerId, newPlayer);
            sortedSet.add(newPlayer);
        } else {
            sortedSet.remove(exist);
            exist.addScore(score);
            sortedSet.add(exist);
        }
    }

    public int top(int k) {
        int topScore = 0;
        Iterator<Player> iterator = sortedSet.iterator();
        while (iterator.hasNext() && k > 0) {
            Player next = iterator.next();
            topScore += next.getScore();
            k--;
        }
        return topScore;
    }

    public void reset(int playerId) {
        Player exist = map.get(playerId);
        if (exist != null) {
            sortedSet.remove(exist);
        }
        Player newPlayer = new Player(playerId, 0);
        map.put(playerId, newPlayer);
        sortedSet.add(newPlayer);
    }
}

class Player implements Comparable<Player> {

    int player;
    int score;

    public Player(int player, int score) {
        this.player = player;
        this.score = score;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int score) {
        this.score = this.score + score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player1 = (Player) o;
        return player == player1.player &&
                score == player1.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, score);
    }

    @Override
    public int compareTo(Player that) {
        int scoreComparison = that.score - this.score;
        return scoreComparison != 0 ? scoreComparison : that.player - this.player;
    }

    @Override
    public String toString() {
        return "Player{" +
                "player=" + player +
                ", score=" + score +
                '}';
    }
}
