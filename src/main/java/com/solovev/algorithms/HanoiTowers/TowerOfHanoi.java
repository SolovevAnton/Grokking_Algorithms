package com.solovev.algorithms.HanoiTowers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Prints necessary steps to bould tower of hanoi for n
 */
public class TowerOfHanoi {

    private static final List<String> moves = new ArrayList<>();
    public static void main(String...args){
        int numberOfDisks = 4; //complexity #1 (O(1))
        findMoves(numberOfDisks,'A','B','C'); //complexity#2 (O(n^2))
        //точно все знают реализацию size() в ArrayList?
        System.out.println("Планируемое количество перемещений: " + moves.size()); //complexity#3 (O(1))
        moves.forEach(System.out::println); //complexity#4 (O(n))
        moves.sort(Comparator.naturalOrder()); //complexity#5 (O(nlog(n))) но это тоже нужно знать реализацию
    }
    public static void findMoves(int numberOfDisks, char tower1, char tower2, char tower3) {
        if (numberOfDisks >= 1) {
            int previousDisc = numberOfDisks - 1;
            findMoves(previousDisc, tower1, tower3, tower2);
            moves.add(String.format("Disk %d moved from %c to %c", numberOfDisks, tower1, tower3));
            findMoves(previousDisc,tower2,tower1,tower3);
        }
    }
}
