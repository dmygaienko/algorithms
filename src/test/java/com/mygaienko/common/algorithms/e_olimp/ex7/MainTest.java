package com.mygaienko.common.algorithms.e_olimp.ex7;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testGetInt() {
        assertEquals(3, Main.getInt("III"));
        assertEquals(1600, Main.getInt("MDC"));
    }

    @Test
    public void testExecute7() {
        assertEquals("VII", Main.execute("III+IV"));
    }

    @Test
    public void testExecute19() {
        assertEquals("XVIIII", Main.execute("III+XVI"));
    }

    @Test
    public void testExecute4() {
        assertEquals("IV", Main.execute("II+II"));
    }


}