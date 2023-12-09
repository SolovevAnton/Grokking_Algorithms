package com.solovev.sort;

class BubbleSortTest extends AbstractSortTest{
    @Override
    protected Sort<Integer> provideSorter() {
        return new BubbleSort<>();
    }
}