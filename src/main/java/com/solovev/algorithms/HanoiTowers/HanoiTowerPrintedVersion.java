package com.solovev.algorithms.HanoiTowers;

/**
 * Tower of hanoi with 3 poles and graphic element
 * example for 2 elements:
 *  ***    |     |
 * *****   |     |
 *---
 *   |     |     |
 * *****  ***    |
 *---
 *   |     |     |
 *   |    ***  *****
 *---
 *   |     |    ***
 *   |     |   *****
 */
public class HanoiTowerPrintedVersion {
    private static final String POLL = "|";
    private static final String DISK_ELEMENT = "*";
    private static final String SPACE = " ";
    private final int[][] state; //this can be done in MAP. Dont know what is better
    private final int numberOfDisks;

    public HanoiTowerPrintedVersion(int numberOfDisks) {
        if (numberOfDisks < 0) {
            throw new IllegalArgumentException("Number of disks must be > 0, but was: " + numberOfDisks);
        }
        this.numberOfDisks = numberOfDisks;
        //fill state
        state = new int[3][numberOfDisks]; // 3 is number of polls
        for (int i = 0; i < numberOfDisks; i++) { // O(n) complexity
            state[0][i] = i + 1; //disk number
        }
    }

    public void findMoves() {
        printCurrentState();
        findMoves(numberOfDisks, 0, 1, 2);
    }

    private void findMoves(int numberOfDisks, int indexTower1, int indexTower2, int indexTower3) { // O(2^n) complexity
        if (numberOfDisks >= 1) {
            int previousDisk = numberOfDisks - 1;
            findMoves(previousDisk, indexTower1, indexTower3, indexTower2);
            moveTopDisk(indexTower1, indexTower3);
            printCurrentState();
            findMoves(previousDisk, indexTower2, indexTower1, indexTower3);
        }
    }

    private void moveTopDisk(int indexTowerFrom, int indexTowerTo) {
        int diskIndexToSwapFrom = getLastEmptyIndex(indexTowerFrom) + 1;
        int diskIndexToSwapTo = getLastEmptyIndex(indexTowerTo);

        state[indexTowerTo][diskIndexToSwapTo] = state[indexTowerFrom][diskIndexToSwapFrom];
        state[indexTowerFrom][diskIndexToSwapFrom] = 0;
    }

    private int getLastEmptyIndex(int towerIndex) { //complexity O(n)
        int currentIndex = 0;
        while (currentIndex < numberOfDisks && state[towerIndex][currentIndex] == 0) {
            currentIndex++;
        }
        return currentIndex - 1;
    }

    private void printCurrentState() {
        StringBuilder wholeStata = new StringBuilder();
        for (int i = 0; i < numberOfDisks; i++) { // complexity O(n^2) complexity, since here 3 polls is also n... however, here its 3n, which is O(n) complexity
            wholeStata.append(getStateLine(i)).append("\n");
        }
        System.out.println(wholeStata);
    }

    private StringBuilder getStateLine(int lineIndex) {
        StringBuilder stateLine = new StringBuilder();
        for (int[] ints : state) {
            stateLine.append(getDiskImage(ints[lineIndex])).append(SPACE);
        }
        return stateLine;
    }

    private String getDiskImage(int diskNumber) {
        String spaces = SPACE.repeat(numberOfDisks - diskNumber);
        String filler = diskNumber == 0 ? POLL : DISK_ELEMENT.repeat(diskNumber * 2 + 1);
        return spaces + filler + spaces;
    }
}
