package com.solovev.algorithms.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest extends AbstractSortTest{
    @Override
    protected Sort<Integer> provideSorter() {
        return new QuickSort<>();
    }
}