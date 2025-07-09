package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StatsWriter { 
    public static void writeToFile (Stats stats){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("game.txt"));
            writer.write("The log for the Tic Tac Toe game is: ");
            writer.write("\nX Wins: " + Integer.toString(stats.getXWins()));
            writer.write("\nO Wins: " + Integer.toString(stats.getOWins()));
            writer.write("\nTies: " + Integer.toString(stats.getTies()));
            writer.close();
        } catch (IOException e) {
            System.out.println("Something went wrong with the writing to file!");
        }
    }
    
    
}
