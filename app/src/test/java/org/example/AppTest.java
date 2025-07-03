package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
  @Test
  void appHasAGreeting() {
    App classUnderTest = new App();
    assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
  }
  @Test
  void SwitchTurnWorks() {
    TurnManagement turnManagement = new TurnManagement();
    turnManagement.setWhosTurn('X');
    turnManagement.SwitchTurn();
    assertEquals('O', turnManagement.getWhosTurn(), "SwitchTurn should change turn from X to O");
    
    turnManagement.SwitchTurn();
    assertEquals('X', turnManagement.getWhosTurn(), "SwitchTurn should change turn from O to X");
  }
   @Test
  void AddToBoardWorks() {
    TicTacToeBoard board = new TicTacToeBoard();
    TurnManagement turnManagement = new TurnManagement();
    char[][] testBoard = board.getBoard();
    
    // Test adding 'X' to the board
    board.addToBoard(1, 'X');
    assertEquals('X', testBoard[0][0], "addToBoard should place 'X' at position 1");
    
    // Test adding 'O' to the board
    turnManagement.setWhosTurn('O');
    board.addToBoard(5, 'O');
    assertEquals('O', testBoard[1][1], "addToBoard should place 'O' at position 5");
  }
  @Test
  void ClearBoardWorks() {
    TicTacToeBoard board = new TicTacToeBoard();
    char[][] testBoard = board.getBoard();
    
    // Fill the board with some values
    testBoard[0][0] = 'X';
    testBoard[1][1] = 'O';
    testBoard[2][2] = 'X';
    
    // Clear the board
    board.clearBoard();
    
    // Check if the board is cleared
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        assertEquals(' ', testBoard[i][j], "clearBoard should reset all positions to empty");
      }
    }
  }
  @Test
  void IsGameDoneWorks() {
    TicTacToeBoard board = new TicTacToeBoard();
    char[][] testBoard = board.getBoard();
    
    // Test for a win condition
    testBoard[0][0] = 'X';
    testBoard[0][1] = 'X';
    testBoard[0][2] = 'X';
    assertTrue(CheckWin.IsGameDone(testBoard), "IsGameDone should return true for a winning condition");
    
    // Reset the board
    board.clearBoard();
    
    // Test for a draw condition
    testBoard[0][0] = 'X';
    testBoard[0][1] = 'O';
    testBoard[0][2] = 'X';
    testBoard[1][0] = 'O';
    testBoard[1][1] = 'X';
    testBoard[1][2] = 'O';
    testBoard[2][0] = 'O';
    testBoard[2][1] = 'X';
    testBoard[2][2] = 'O';
    
    assertTrue(CheckWin.IsGameDone(testBoard), "IsGameDone should return true for a draw condition");
  }
  @Test
  void isValidInputWorks() {
    InputHandler inputHandler = new InputHandler();

    // Test valid inputs
    assertTrue(inputHandler.isValidInput("1"), "isValidInput should return true for valid input '1'");
    assertTrue(inputHandler.isValidInput("5"), "isValidInput should return true for valid input '5'");
    
    // Test invalid inputs
    assertFalse(inputHandler.isValidInput("10"), "isValidInput should return false for invalid input '10'");
    assertFalse(inputHandler.isValidInput("0"), "isValidInput should return false for invalid input '0'");
    assertFalse(inputHandler.isValidInput(" "), "isValidInput should return false for non-numeric input ' '");
    assertFalse(inputHandler.isValidInput(""), "isValidInput should return false for non-numeric input ''");
    assertFalse(inputHandler.isValidInput("a"), "isValidInput should return false for non-numeric input 'a'");

    // Test already used inputs
    assertFalse(inputHandler.isValidInput("1"), "isValidInput should return false for already used input '3'");
  }
}
