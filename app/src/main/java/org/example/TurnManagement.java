package org.example;

public class TurnManagement {//manages which turn it is
    private char WhosTurn = 'X';
    private int turnCount = 0;

    public char getWhosTurn() { return WhosTurn; }

    public void setWhosTurn(char whosTurn) { WhosTurn = whosTurn; }

    public void switchTurn() {
        if (WhosTurn == 'X') { WhosTurn = 'O'; }
        else { WhosTurn = 'X'; }
    } 

    public void incrementTurnCount() {
        turnCount++;
    }

    public int getTurnCount() {
        return turnCount;
    }
}
