package org.example;

public class Stats {//holds and keeps track of game statistics
    private int xWins = 0;
    private int oWins = 0;
    private int ties = 0;

    public void incrementXWins() {
        xWins++;
    }

    public void incrementOWins() {
        oWins++;
    }

    public void incrementTies() {
        ties++;
    }

    public int getXWins() {
        return xWins;
    }

    public int getOWins() {
        return oWins;
    }

    public int getTies() {
        return ties;
    }

    public void clearStats() {
        xWins = 0;
        oWins = 0;
        ties = 0;
    }
}
