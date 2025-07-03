package org.example;
import java.util.Scanner;

public class App {
  public String getGreeting() {
    return "Hello World!";
  }

  public static void main(String[] args) {
    TicTacToeBoard board = new TicTacToeBoard();
    Scanner scanner = new Scanner(System.in);
    InputHandler inputHandler = new InputHandler();
    TurnManagement turnManagement = new TurnManagement();
    System.out.println("Welcome to Tic Tac Toe!\n");
    String userInput;
    do{//could put this into a play game class?
      PrintBoard.printBoard(board.getBoard()); 
      while (true){
        System.out.println("What is your move? (1-9) ");
        userInput = scanner.nextLine();
        if (inputHandler.isValidInput(userInput)) {
          int position = Integer.parseInt(userInput);
          board.addToBoard(position, turnManagement.getWhosTurn());
          turnManagement.SwitchTurn();
          break;
        } 
    
    }
    }while (!CheckWin.IsGameDone(board.getBoard()));
    scanner.close();
  }
}
