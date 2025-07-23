package org.example;

public class TicTacToeBoard {//holds and keeps track of board
    private char[][] board = {{'1','2','3'},
                              {'4','5','6'},
                              {'7','8','9'}};
    public void addToBoard(Integer position, char WhosTurn) {
        switch (position) {
            case 1 -> board[0][0] = WhosTurn;
            case 2 -> board[0][1] = WhosTurn;
            case 3 -> board[0][2] = WhosTurn;
            case 4 -> board[1][0] = WhosTurn;
            case 5 -> board[1][1] = WhosTurn;
            case 6 -> board[1][2] = WhosTurn;
            case 7 -> board[2][0] = WhosTurn;
            case 8 -> board[2][1] = WhosTurn;
            case 9 -> board[2][2] = WhosTurn;
        }
    }
    public void clearBoard() {
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                int temp = (3 * i) + j + 1;
                board[i][j] = (char) (temp + '0'); // Convert int to char
            }
        }
    }
    public char[][] getBoard() {
        return board;
    }
    public boolean isBoardEmpty() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((board[i][j] == 'X') | (board[i][j] == 'O')) {
                    return false; // Found a cell that is not empty
                }
            }
        }
        return true; // All cells are empty
    }
}
