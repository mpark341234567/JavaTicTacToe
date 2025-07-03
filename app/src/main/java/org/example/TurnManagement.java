package org.example;

public class TurnManagement {//manages which turn it is
    public char WhosTurn = 'X';

    public char getWhosTurn() { return WhosTurn; }

    public void setWhosTurn(char whosTurn) { WhosTurn = whosTurn; }

    public void SwitchTurn() {
        if (WhosTurn == 'X') { WhosTurn = 'O'; }
        else { WhosTurn = 'X'; }
    } 
}
