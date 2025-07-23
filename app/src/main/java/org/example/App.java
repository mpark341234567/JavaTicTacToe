package org.example;
import java.util.Scanner;

public class App {
  public String getGreeting() {
    return "Hello World!";
  }

  public static void main(String[] args) {
    TicTacToeBoard board = new TicTacToeBoard();
    Scanner scanner = new Scanner(System.in);
    InputHandler inputHandler = new InputHandler(scanner);
    TurnManagement turnManagement = new TurnManagement();
    Stats stats = new Stats();
    GameController gameController = new GameController(board, inputHandler, turnManagement, stats);
    System.out.println("Welcome to Tic Tac Toe!\n");
    gameController.chooseGame();
    scanner.close();
  }
}
