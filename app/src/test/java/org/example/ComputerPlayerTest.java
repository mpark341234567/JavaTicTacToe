package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComputerPlayerTest {
    @Test
    void getCornerMoveWorks() {
        ComputerPlayer computerPlayer = new ComputerPlayer('X', 'O');
        char[][] board = new char[3][3];
        int move = computerPlayer.getMove(board, true, true);
        
        // Check if the move is one of the corners
        assertTrue(move == 1 || move == 3 || move == 7 || move == 9, "getCornerMove should return a corner position");
    }
    @Test
    void getCenterMoveWorks() {
        ComputerPlayer computerPlayer = new ComputerPlayer('X', 'O');
        char[][] board = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
        };
        int move = computerPlayer.getMove(board, true, false);
        
        // Check if the center move is returned
        assertEquals(5, move, "getCenterMove should return position 5 for the center");
    }
    @Test
    void getWinningMoveWorks() {
        ComputerPlayer computerPlayer = new ComputerPlayer('X', 'O');
        char[][] board = {
            {'X', 'X', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
        };
        int move = computerPlayer.getMove(board, false, false);
        
        // Check if the winning move is returned
        assertEquals(3, move, "getWinningMove should return position 3 for a winning move");
    }
    @Test
    void getBlockingMoveWorks() {
        ComputerPlayer computerPlayer = new ComputerPlayer('X', 'O');
        char[][] board = {
            {'O', 'O', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
        };
        int move = computerPlayer.getMove(board, false, false);
        
        // Check if the blocking move is returned
        assertEquals(3, move, "getBlockingMove should return position 3 to block opponent's winning move");
    }
    @Test
    void getRandomMoveWorks() {
        ComputerPlayer computerPlayer = new ComputerPlayer('X', 'O');
        char[][] board = {
            {'X', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', 'O'}
        };
        int move = computerPlayer.getMove(board, false, false);
        assertNotEquals('1', move);
        assertNotEquals('9', move);
    }
}
