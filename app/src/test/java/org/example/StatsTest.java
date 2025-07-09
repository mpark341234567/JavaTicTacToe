package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StatsTest {
    @Test
    void testIncrementXWins() {
        Stats stats = new Stats();
        stats.incrementXWins();
        assertEquals(1, stats.getXWins(), "X wins should be incremented to 1");
    }
    @Test
    void testIncrementOWins() {
        Stats stats = new Stats();
        stats.incrementOWins();
        assertEquals(1, stats.getOWins(), "O wins should be incremented to 1");
    }
    @Test
    void testIncrementTies() {
        Stats stats = new Stats();
        stats.incrementTies();
        assertEquals(1, stats.getTies(), "Ties should be incremented to 1");
    }
    @Test
    void testClearStats() {
        Stats stats = new Stats();
        stats.incrementXWins();
        stats.incrementOWins();
        stats.incrementTies();
        
        stats.clearStats();
        
        assertEquals(0, stats.getXWins(), "X wins should be reset to 0");
        assertEquals(0, stats.getOWins(), "O wins should be reset to 0");
        assertEquals(0, stats.getTies(), "Ties should be reset to 0");
    }
}
