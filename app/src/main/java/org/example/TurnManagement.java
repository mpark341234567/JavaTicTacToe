package org.example;

public class TurnManagement {//manages which turn it is
    public static char WhosTurn = 'X';

    public static char getWhosTurn() { return WhosTurn; }

    public static void setWhosTurn(char whosTurn) { WhosTurn = whosTurn; }

    public static void SwitchTurn() {
        if (WhosTurn == 'X') { WhosTurn = 'O'; }
        else { WhosTurn = 'X'; }
    } 
}
