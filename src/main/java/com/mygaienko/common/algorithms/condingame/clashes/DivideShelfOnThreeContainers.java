package com.mygaienko.common.algorithms.condingame.clashes;

import java.util.*;
import java.io.*;
import java.math.*;

public class DivideShelfOnThreeContainers {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of containers on the shelf.
        if (in.hasNextLine()) {
            in.nextLine();
        }

        String rowShelf = in.nextLine(); // The shelf.
        String[] shelf = rowShelf.split(" ");

        long sum = Arrays.stream(shelf)
                .map(value -> Long.valueOf(value))
                .reduce(0L, Long::sum);

        long groupSum = sum / 3;
        System.err.println(sum);

        StringBuilder builder = new StringBuilder();

        long localSum = 0;
        long groupCount = 0;

        for (String container : shelf) {
            localSum = localSum + Long.valueOf(container);
            builder.append(container);
            builder.append(" ");
            if (localSum == groupSum) {
                localSum = 0;
                if (groupCount < 2) {
                    builder.append(" | ");
                    groupCount = groupCount + 1;
                }
            }
        }

        System.out.println(builder.toString());
    }

}
