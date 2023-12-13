package com.solovev.algorithms.sort;

import static org.junit.jupiter.api.Assertions.*;

class ShellSortTest extends AbstractSortTest{
    @Override
    protected Sort<Integer> provideSorter() {
        return new ShellSort<>();
    }
}