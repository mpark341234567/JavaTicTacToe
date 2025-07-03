package org.example;
// import java.util.Scanner;
import java.util.ArrayList;

public class InputHandler {//handles invalid inputs and user inputs
    private ArrayList<String> availableInputs = new ArrayList<>();
    // public boolean playerTurn(TicTacToeBoard board, Scanner scanner){
    //     String userInput;
    //     while (true){
    //         System.out.println("What is your move? (1-9) ");
    //         userInput = scanner.nextLine();
    //         if (isValidInput(userInput)) {
    //         return true;
    //     } 
    // }
    // }

    public boolean isValidInput(String input){
        switch (input) {
            case "1", "2", "3", "4", "5", "6", "7", "8", "9" -> {
                if (availableInputs.contains(input)) {
                    System.out.println("\nThis position is already taken!\n");
                    return false;
                } else {
                    availableInputs.add(input);
                    return true;
                }
            }
            default -> {
                System.out.println("\nInvalid input!\n");
                return false;
            }
        }
    }
}
