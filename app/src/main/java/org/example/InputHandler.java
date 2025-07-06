package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class InputHandler {//handles invalid inputs and user inputs
    private Scanner scanner;
    private ArrayList<String> availableInputs = new ArrayList<>();

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getInput() {
        String userInput;
        while (true) {
            System.out.println("What is your move? (1-9) ");
            userInput = scanner.nextLine();
            if (isValidInput(userInput)) {
                return Integer.parseInt(userInput);
        }
    }
}

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
