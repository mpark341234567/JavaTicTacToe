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
    GameController gameController = new GameController(board, inputHandler, turnManagement);
    gameController.playGame();
    scanner.close();
  }
}
