package com.mygaienko.common.algorithms.condingame.clashes;

import org.junit.Test;

import java.util.ArrayList;

public class FindWinnersTest {

    @Test
    public void testFindWinners() {
        ArrayList<Integer> winners = new ArrayList<>();
        FindWinners.findWinners("OOOXOOXOXXXXOOX", 0, winners);
        System.out.println(winners);
    }

}