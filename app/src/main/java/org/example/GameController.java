package org.example;

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
        
        }
}
