package org.example;

import java.util.ArrayList;

public class GameController {
    private TicTacToeBoard board;
    private InputHandler inputHandler;
    private TurnManagement turnManagement;
    private Stats stats;
    private int gameType;
    private int result;
    public GameController(TicTacToeBoard board, InputHandler inputHandler, TurnManagement turnManagement, Stats stats) {
        this.board = board;
        this.inputHandler = inputHandler;
        this.turnManagement = turnManagement;
        this.stats = stats;
    }
    public void playGame() {
        result = -1;
        PrintBoard.printBoard(board.getBoard()); 
        do{
            int position = inputHandler.getInput();
            board.addToBoard(position, turnManagement.getWhosTurn());
            turnManagement.switchTurn();
            result = CheckWin.IsGameDone(board.getBoard());
            PrintBoard.printBoard(board.getBoard()); 
        }while (result == -1);

        if (result == 0) {
                CheckWin.XWinMessage();
                turnManagement.setWhosTurn('O');
                stats.incrementXWins();
            } else if (result == 1) {
                CheckWin.OWinMessage();
                turnManagement.setWhosTurn('X');
                stats.incrementOWins();
            }
            else {
                CheckWin.TieMessage();
                stats.incrementTies();
            }
        PrintStats.printStats(stats);
        replayGame();
        }

    public void replayGame() {
        System.out.println("Would you like to play again? (Y/N)");
        if (inputHandler.getInputReplay().equals("Y")) {
            board.clearBoard();
            inputHandler.setAvailableInputs(new ArrayList<String>());
            turnManagement.resetTurnCount();
            if (gameType == 1) {//player vs player
            playGame();
            }
            else if (gameType == 2) {//computer vs player
            ComputerPlayer comFirst = new ComputerPlayer('X', 'O');
            playVsComputer(comFirst);
            }
            else {//player vs computer
            ComputerPlayer comSecond = new ComputerPlayer('O', 'X');
            playVsComputer(comSecond);
            } 
        }
        else {
            System.out.println("Thanks for playing!");
            System.out.println("Writing game log to 'game.txt'. Check 'game.txt' to see your stats!");
            StatsWriter.writeToFile(stats);
        }
    }

    public void playVsComputer(ComputerPlayer com) {
        int result = -1;
        PrintBoard.printBoard(board.getBoard());
        do {
            char currentTurn = turnManagement.getWhosTurn();
            if (com.getComputerMark() == currentTurn) {
                int position = com.getMove(board.getBoard(),((turnManagement.getTurnCount() == 2) || (turnManagement.getTurnCount() == 3)),board.isBoardEmpty());
                System.out.println("Computer is moving...");
                board.addToBoard(position, turnManagement.getWhosTurn());
            } else {
                int position = inputHandler.getInput();
                board.addToBoard(position, turnManagement.getWhosTurn());
            }
            turnManagement.switchTurn();
            result = CheckWin.IsGameDone(board.getBoard());
            PrintBoard.printBoard(board.getBoard());
        } while (result == -1);

        if (result == 0) {
            CheckWin.XWinMessage();
            turnManagement.setWhosTurn('O');
            stats.incrementXWins();
        } else if (result == 1) {
            CheckWin.OWinMessage();
            turnManagement.setWhosTurn('X');
            stats.incrementOWins();
        } else {
            CheckWin.TieMessage();
            stats.incrementTies();
        }
        PrintStats.printStats(stats);
        replayGame();
    }

    public void chooseGame() {
        gameType = inputHandler.getGameType();
        if (gameType == 1) {//player vs player
            playGame();
        }
        else if (gameType == 2) {//computer vs player
            ComputerPlayer comFirst = new ComputerPlayer('X', 'O');
            playVsComputer(comFirst);
        }
        else {//player vs computer
            ComputerPlayer comSecond = new ComputerPlayer('O', 'X');
            playVsComputer(comSecond);
        }
    }
}
