package org.example;
import java.util.Scanner;

public class App {
  public String getGreeting() {
    return "Hello World!";
  }

  public static void main(String[] args) {
    TicTacToeBoard board = new TicTacToeBoard();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to Tic Tac Toe!\n");
    
    do{
      PrintBoard.printBoard(board.getBoard());
      InputHandler.playerTurn(board, scanner);
    }while (!CheckWin.IsGameDone(board.getBoard()));
    
  }
}
