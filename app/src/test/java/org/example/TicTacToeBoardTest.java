package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeBoardTest {
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
}
