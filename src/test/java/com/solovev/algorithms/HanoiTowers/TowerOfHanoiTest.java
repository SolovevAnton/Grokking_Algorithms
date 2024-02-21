package com.solovev.algorithms.HanoiTowers;

import org.junit.jupiter.api.Test;

class TowerOfHanoiTest {
    @Test
    public void move1(){
        callHanoiFor(1);
    }
    @Test
    public void move2(){
        callHanoiFor(2);
    }
    @Test
    public void move3(){
        callHanoiFor(3);
    }
    @Test
    public void move4(){
        callHanoiFor(4);
    }
    private void callHanoiFor(int n){
        TowerOfHanoi.findMoves(n,'A','B','C');
    }

}