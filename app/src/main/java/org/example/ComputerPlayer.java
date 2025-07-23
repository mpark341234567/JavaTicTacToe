package org.example;

import java.util.Random;
import java.util.ArrayList;

public class ComputerPlayer {
    Random random = new Random();
    private char ComputerMark;
    private char OpponentMark;

    public ComputerPlayer(char computerMark, char opponentMark) {
        this.ComputerMark = computerMark;
        this.OpponentMark = opponentMark;
    }

    public int getMove(char[][] board, boolean isSecondTurn, boolean isBoardEmpty) {
        if (isBoardEmpty) {
            return getCornerMove(); // First move, choose a corner
        }
        else if ((isSecondTurn) && (board[1][1] == '5')) {
            return 5; // Second turn, take the center if available
        }
        int winningMove = getWinningMove(board, ComputerMark);
        if (winningMove != -1) {
            return winningMove; // Check for winning move
        }
        int blockingMove = getBlockingMove(board, OpponentMark);
        if (blockingMove != -1) {
            return blockingMove; // Block opponent's winning move
        }
        return getRandomMove(board); // Otherwise, choose a random available move
    }

    private int getCornerMove() {
        int[] corners = {1, 3, 7, 9};
        return corners[random.nextInt(4)];
    }

    private int getWinningMove(char[][] board, char computerMark){
        int winningNumber = ((computerMark == 'X') ? 0 : 1);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char currentCell = board[i][j];//hold the blank board cell
                if ((currentCell >= '1') && (currentCell <= '9')) {
                    board[i][j] = computerMark; // Temporarily place the computer's mark
                    if (CheckWin.IsGameDone(board) == winningNumber) {
                        board[i][j] = currentCell; // Reset the cell
                        return (3 * i) + j + 1; // Return the winning move position
                    }
                    board[i][j] = currentCell; // Reset the cell
                }
            }
        }
        return -1; // No winning move found
    }

    private int getBlockingMove(char[][] board, char opponentMark) {
        int blockingNumber = ((opponentMark == 'X') ? 0 : 1);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char currentCell = board[i][j]; // hold the blank board cell
                if ((currentCell >= '1') && (currentCell <= '9')) {
                    board[i][j] = opponentMark; // Temporarily place the opponent's mark
                    if (CheckWin.IsGameDone(board) == blockingNumber) {
                        board[i][j] = currentCell; // Reset the cell
                        return (3 * i) + j + 1; // Return the blocking move position
                    }
                    board[i][j] = currentCell; // Reset the cell
                }
            }
        }
        return -1; // No blocking move found
    }

    private int getRandomMove(char[][] board) {
        ArrayList<Integer> availableMoves = new ArrayList<>(); // Get all available moves
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char currentCell = board[i][j];
                if ((currentCell >= '1') && (currentCell <= '9')) {
                    availableMoves.add((3 * i) + j + 1); // Add available positions
                }
            }
    }
    if (!availableMoves.isEmpty()) {
            return availableMoves.get(random.nextInt(availableMoves.size())); // Return a random available move
    }
    return -1; // No available moves found
}
    public char getComputerMark() {return ComputerMark;}
}
