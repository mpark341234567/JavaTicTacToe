package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TurnManagementTest {
@Test
void SwitchTurnWorks() {
    TurnManagement turnManagement = new TurnManagement();
    turnManagement.setWhosTurn('X');
    turnManagement.SwitchTurn();
    assertEquals('O', turnManagement.getWhosTurn(), "SwitchTurn should change turn from X to O");
    
    turnManagement.SwitchTurn();
    assertEquals('X', turnManagement.getWhosTurn(), "SwitchTurn should change turn from O to X");
  }
}
