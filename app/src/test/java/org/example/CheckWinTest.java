package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

public class CheckWinTest {
@Test
void isValidInputWorks() {
    Scanner scanner = new Scanner(System.in);
    InputHandler inputHandler = new InputHandler(scanner);

    // Test valid inputs
    assertTrue(inputHandler.isValidInput("1"), "isValidInput should return true for valid input '1'");
    assertTrue(inputHandler.isValidInput("5"), "isValidInput should return true for valid input '5'");
    
    // Test invalid inputs
    assertFalse(inputHandler.isValidInput("10"), "isValidInput should return false for invalid input '10'");
    assertFalse(inputHandler.isValidInput("0"), "isValidInput should return false for invalid input '0'");
    assertFalse(inputHandler.isValidInput(" "), "isValidInput should return false for non-numeric input ' '");
    assertFalse(inputHandler.isValidInput(""), "isValidInput should return false for non-numeric input ''");
    assertFalse(inputHandler.isValidInput("a"), "isValidInput should return false for non-numeric input 'a'");

    // Test already used inputs
    assertFalse(inputHandler.isValidInput("1"), "isValidInput should return false for already used input '3'");
  }
}
