package org.example;

public class CheckWin {//checks for valid win condition
    public static int IsGameDone(char [][] board){ 
        if (HasPlayerWon(board, 'X')){
            PrintBoard.printBoard(board);
            System.out.println("Player X has won!");
            return 0;
        }
        else if (HasPlayerWon(board, 'O')){
            PrintBoard.printBoard(board);
            System.out.println("Player O has won!");
            return 1;
        }
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if ((board[i][j] != 'X') && (board[i][j] != 'O')) {
                    return -1; 
                }
            }
        }
        PrintBoard.printBoard(board);
        System.out.println("The game is a draw!");
        return 2; 
    }

    private static boolean HasPlayerWon(char[][] board, char player) {
        if (((board[0][0] == player) && (board[0][1] == player) && (board[0][2] == player)) || //row 1
            ((board[1][0] == player) && (board[1][1] == player) && (board[1][2] == player)) ||//row 2
            ((board[2][0] == player) && (board[2][1] == player) && (board[2][2] == player)) ||//row 3
            
            ((board[0][0] == player) && (board[1][0] == player) && (board[2][0] == player)) || //column 1
            ((board[0][1] == player) && (board[1][1] == player) && (board[2][1] == player)) || //column 2
            ((board[0][2] == player) && (board[1][2] == player) && (board[2][2] == player)) || //column 3
            
            ((board[0][0] == player) && (board[1][1] == player) && (board[2][2] == player)) ||//top left to bottom right diagonal
            ((board[0][2] == player) && (board[1][1] == player) && (board[2][0] == player))) {//top right to bottom left diagonal
            return true;
        }
        else { return false; }
    }
}
