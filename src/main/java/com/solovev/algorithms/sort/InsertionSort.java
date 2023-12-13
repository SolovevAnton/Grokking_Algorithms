package com.solovev.algorithms.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertionSort<T extends Comparable<T>> implements Sort<T> {
    private List<T> result;
    private int currentIndex;

    @Override
    public List<T> sort(List<T> unsorted) {
        result = new ArrayList<>(unsorted);
        int size = unsorted.size();
        for (int i = 0; i < size; i++) {
            currentIndex = i;
            while (currentIndex > 0 && isCurrentSmallerThanPrevious()) {
                Collections.swap(result,currentIndex - 1,currentIndex);
                currentIndex--;
            }
        }
        return result;
    }

    private boolean isCurrentSmallerThanPrevious() {
        return result.get(currentIndex).compareTo(result.get(currentIndex-1)) < 0;
    }
}
