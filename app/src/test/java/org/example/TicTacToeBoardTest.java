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
    char[][] testBoard = {{'1','2','3'},
                          {'4','5','6'},
                          {'7','8','9'}};
    
    // Fill the board with some values
    board.addToBoard(1, 'X');
    board.addToBoard(2, 'O');
    board.addToBoard(3, 'X');
    
    // Clear the board
    board.clearBoard();
    
    // Check if the board is cleared
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        assertEquals(testBoard[i][j], (board.getBoard())[i][j], "clearBoard should reset all positions to numeric values");
      }
    }
  }
}
