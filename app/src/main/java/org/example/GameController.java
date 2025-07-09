package org.example;

import java.util.ArrayList;

public class GameController {
    private TicTacToeBoard board;
    private InputHandler inputHandler;
    private TurnManagement turnManagement;
    private Stats stats;
    public GameController(TicTacToeBoard board, InputHandler inputHandler, TurnManagement turnManagement, Stats stats) {
        this.board = board;
        this.inputHandler = inputHandler;
        this.turnManagement = turnManagement;
        this.stats = stats;
    }
    public void playGame() {
       
        do{
        PrintBoard.printBoard(board.getBoard()); 
        while (true){
            int position = inputHandler.getInput();
            board.addToBoard(position, turnManagement.getWhosTurn());
            turnManagement.switchTurn();
            break;
            } 
        }while (CheckWin.IsGameDone(board.getBoard()) == -1);

        if (CheckWin.IsGameDone(board.getBoard()) == 0) {
                turnManagement.setWhosTurn('O');
                stats.incrementXWins();
            } else if (CheckWin.IsGameDone(board.getBoard()) == 1) {
                turnManagement.setWhosTurn('X');
                stats.incrementOWins();
            }
            else {
                stats.incrementTies();
            }
        PrintStats.printStats(stats);
        replayGame();
        }
    public void replayGame() {
        System.out.println("Would you like to play again? (Y/N)");
        if (inputHandler.getInputReplay().equals("Y")) {
            if (CheckWin.IsGameDone(board.getBoard()) == 0) {
                turnManagement.setWhosTurn('O');
            } else {
                turnManagement.setWhosTurn('X');
            }
            board.clearBoard();
            inputHandler.setAvailableInputs(new ArrayList<String>());
            playGame();
        }
        else {
            System.out.println("Thanks for playing!");
            System.out.println("Writing game log to 'game.txt'. Check 'game.txt' to see your stats!");
            StatsWriter.writeToFile(stats);
        }
    }
}
