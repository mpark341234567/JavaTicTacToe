package org.example;

public class PrintBoard {//displays board to terminal
    public static void printBoard(char[][] print) {// a for loop could make this better...
        System.out.println("  " + print[0][0] + "  |  " + print[0][1] + "  |  " + print[0][2]);
        System.out.println("-----+-----+-----");
        System.out.println("  " + print[1][0] + "  |  " + print[1][1] + "  |  " + print[1][2]);
        System.out.println("-----+-----+-----");
        System.out.println("  " + print[2][0] + "  |  " + print[2][1] + "  |  " + print[2][2]);
    }
}
