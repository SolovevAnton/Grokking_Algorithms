package com.solovev.algorithms.HanoiTowers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HanoiTowerPrintedVersionTest {
    @Test
    public void moveNegative(){
        assertThrows(IllegalArgumentException.class, () ->callHanoiFor(-1));
    }
    @Test
    public void move0(){
        callHanoiFor(0);
    }

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
        new HanoiTowerPrintedVersion(n).findMoves();
    }

}