package com.mygaienko.common.algorithms.e_olimp.ex4;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testExecute() {
        assertEquals(2, Main.execute(0, 0, 5, 5, 0, 1));
        assertEquals(0, Main.execute(0, 0, 5, 0, 0, 1));
    }

    @Test
    public void testExecute0WithSameXY() {
        assertEquals(0, Main.execute(0, 0, 5, 0, 0, 1));
    }

    @Test
    public void testExecute0WithDiffXY() {
        assertEquals(0, Main.execute(0, 0, 5, 0, 1, 1));
    }

    @Test
    public void testExecute1WithDiffXY() {
        assertEquals(1, Main.execute(0, 0, 5, 0, 4, 1));
    }

    @Test
    public void testExecute2WithDiffXY() {
        assertEquals(2, Main.execute(0, 0, 5, 0, 4, 1.5d));
    }

    @Test
    public void testExecute0WithDiffXYOut() {
        assertEquals(0, Main.execute(0, 0, 5, 0, 10, 1));
    }

}