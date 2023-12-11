package com.solovev.algorithms.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectionSort<T extends Comparable<T>> implements Sort<T> {
    private List<T> result;
    private int minIndex;

    @Override
    public List<T> sort(List<T> unsorted) {
        result = new ArrayList<>(unsorted);
        int size = unsorted.size();
        for (int i = 0; i < size; i++) {
            minIndex = i;
            for (int j = size - 1; j > i; j--) {
                if (isSmallerThanMin(j)) {
                    minIndex = j;
                }
            }
            Collections.swap(result,i,minIndex);
        }
        return result;
    }

    private boolean isSmallerThanMin(int indexOfElement) {
        return result.get(minIndex).compareTo(result.get(indexOfElement)) > 0;
    }
}
