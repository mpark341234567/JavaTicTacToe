package org.example;
import java.util.Scanner;

public class InputHandler {//handles invalid inputs and user inputs
    public static void playerTurn(TicTacToeBoard board, Scanner scanner){
        String userInput;
        while (true){
            System.out.println("What is your move? (1-9) ");
            userInput = scanner.nextLine();
            if (isValidInput(userInput)) {
            break;
        } 
    }
        int position = Integer.parseInt(userInput);
        board.addToBoard(position, TurnManagement.getWhosTurn());
        TurnManagement.SwitchTurn();
    }
    private static boolean isValidInput(String input){
        switch (input) {
            case "1", "2", "3", "4", "5", "6", "7", "8", "9" -> {
                return true;
            }
            default -> {
                System.out.println("\nInvalid input!\n");
                return false;
            }
        }
    }
}
