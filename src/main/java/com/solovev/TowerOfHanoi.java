package com.solovev;

/**
 * Prints necessary steps to bould tower of hanoi for n
 */
public class TowerOfHanoi {
    private static final String message = "Disk %d moved from %c to %c\n";

    public static void findMoves(int numberOfDisks, char tower1, char tower2, char tower3) {
        if (numberOfDisks >= 1) {
            int previousDisc = numberOfDisks - 1;
            findMoves(previousDisc, tower1, tower3, tower2);
            printMessage(numberOfDisks, tower1, tower3);
            findMoves(previousDisc,tower2,tower1,tower3);
        }
    }

    private static void printMessage(int diskNumber, char fromTower, char toTower) {
        System.out.format(message, diskNumber, fromTower, toTower);
    }
}
