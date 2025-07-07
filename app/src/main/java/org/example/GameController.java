package org.example;

import java.util.ArrayList;

public class GameController {
    private TicTacToeBoard board;
    private InputHandler inputHandler;
    private TurnManagement turnManagement;
    public GameController(TicTacToeBoard board, InputHandler inputHandler, TurnManagement turnManagement) {
        this.board = board;
        this.inputHandler = inputHandler;
        this.turnManagement = turnManagement;
    }
    public void playGame() {
        System.out.println("Welcome to Tic Tac Toe!\n");
        do{
        PrintBoard.printBoard(board.getBoard()); 
        while (true){
            int position = inputHandler.getInput();
            board.addToBoard(position, turnManagement.getWhosTurn());
            turnManagement.switchTurn();
            break;
            } 
        }while (!CheckWin.IsGameDone(board.getBoard()));
        replayGame();
        }
    public void replayGame() {
        System.out.println("Would you like to play again? (Y/N)");
        if (inputHandler.getInputReplay().equals("Y")) {
            board.clearBoard();
            turnManagement.setWhosTurn('X');
            inputHandler.setAvailableInputs(new ArrayList<String>());
            playGame();
        }
        else {
            System.out.println("Thanks for playing!");
        }
    }
}
