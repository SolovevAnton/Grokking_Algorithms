package com.solovev.algorithms.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSort<T extends Comparable<T>> implements Sort<T> {
    private List<T> result;

    @Override
    public List<T> sort(List<T> unsorted) {
        result = new ArrayList<>(unsorted);
        quickSort(0, unsorted.size() - 1);
        return result;
    }

    private void quickSort(int start, int endIndex) {
        if (start < endIndex) {
            int pivotElement = partSort(start, endIndex); //pivot will be put in place here!
            quickSort(start, pivotElement - 1);
            quickSort(pivotElement + 1, endIndex);
        }
    }

    /**
     * sorts based on the pivot element, all smaller goes to the left, larger, to the right
     *
     * @param start
     * @param end
     * @return new index of the partition element after sorting
     */
    private int partSort(int start, int end) {
        int pivotElementIndex = end;
        int leftIndex = start;
        for (int rightIndex = start; rightIndex < end; rightIndex++) {
            if (firstIsSmaller(rightIndex, pivotElementIndex)) {
                swap(leftIndex, rightIndex);
                leftIndex++;
            }
        }
        swap(pivotElementIndex, leftIndex);
        return leftIndex;
    }

    private boolean firstIsSmaller(int indexOfElement1, int indexOfElement2) {
        return result.get(indexOfElement1).compareTo(result.get(indexOfElement2)) < 0;
    }

    private void swap(int index1, int index2) {
        Collections.swap(result, index1, index2); //if element indexes are equal does not change
    }
}
