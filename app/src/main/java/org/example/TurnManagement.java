package org.example;

public class TurnManagement {//manages which turn it is
    private char WhosTurn = 'X';

    public char getWhosTurn() { return WhosTurn; }

    public void setWhosTurn(char whosTurn) { WhosTurn = whosTurn; }

    public void switchTurn() {
        if (WhosTurn == 'X') { WhosTurn = 'O'; }
        else { WhosTurn = 'X'; }
    } 
}
