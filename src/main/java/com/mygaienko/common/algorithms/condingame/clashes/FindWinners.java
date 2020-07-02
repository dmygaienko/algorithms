package com.mygaienko.common.algorithms.condingame.clashes;

import java.util.*;
import java.io.*;
import java.math.*;

public class FindWinners {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int C = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        Map<Integer, Integer> scores = new HashMap<>();
        for (int i = 0; i < C; i++) {
            String ROW = in.nextLine();

            List<Integer> winners = new ArrayList<>();

            findWinners(ROW, 0, winners);
            int score = N / winners.size();

            winners.forEach(i1 -> scores.merge(i1, score, (oldValue, newValue) -> oldValue + newValue));
        }

        int winnerId = 0;
        int winnerScore = 0;
        for (Map.Entry<Integer, Integer> entry : scores.entrySet()) {
            if (entry.getValue() > winnerScore) {
                winnerScore = entry.getValue();
                winnerId = entry.getKey();
            }
        }
        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(winnerId + " " + winnerScore);
    }

    public static void findWinners(String row, int i, List<Integer> winners) {
        int index = row.indexOf("X", i);
        if (index > -1) {
            winners.add(index);
            findWinners(row, index + 1, winners);
        }
    }

    public static void findWinnersIterative(String row, List<Integer> winners) {
        for (int j = 0; j < row.length(); j++) {
            int index = row.indexOf("X", j);
            if (index == -1) {
                break;
            }
            j = index;
            winners.add(j);
        }
    }

}
