package org.example;

public class PrintStats {
    public static void printStats(Stats stats) {
        System.out.println("The current log is:");
        System.out.println("X Wins: " + stats.getXWins());
        System.out.println("O Wins: " + stats.getOWins());
        System.out.println("Ties: " + stats.getTies());
    }
}
