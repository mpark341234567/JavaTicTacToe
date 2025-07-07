package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

public class InputHandlerTest {
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
@Test
void isValidReplayInputWorks() {
    Scanner scanner = new Scanner(System.in);
    InputHandler inputHandler = new InputHandler(scanner);

    // Test valid replay inputs
    assertTrue(inputHandler.isValidReplayInput("Y"), "isValidReplayInput should return true for 'Y'");
    assertTrue(inputHandler.isValidReplayInput("y"), "isValidReplayInput should return true for 'y'");
    assertTrue(inputHandler.isValidReplayInput("N"), "isValidReplayInput should return true for 'N'");
    assertTrue(inputHandler.isValidReplayInput("n"), "isValidReplayInput should return true for 'n'");

    // Test invalid replay inputs
    assertFalse(inputHandler.isValidReplayInput("Maybe"), "isValidReplayInput should return false for invalid input 'Maybe'");
    assertFalse(inputHandler.isValidReplayInput(" "), "isValidReplayInput should return false for non-numeric input ' '");
    assertFalse(inputHandler.isValidReplayInput(""), "isValidReplayInput should return false for non-numeric input ''");
    assertFalse(inputHandler.isValidReplayInput("7"), "isValidReplayInput should return false for numeric input '7'");
    assertFalse(inputHandler.isValidReplayInput("#"), "isValidReplayInput should return false for symbol input '#'");
  }
}
