package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CheckWinTest {
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
}
