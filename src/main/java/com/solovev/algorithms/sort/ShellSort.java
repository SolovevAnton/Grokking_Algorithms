package com.solovev.algorithms.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 **Shell sort** improved [[Insertion sort Algorithm|insertion sort]]  main idea,
 * is to have insertion sort, but with steps between sorted indexes
 * (this helps to reduce distance, that each element have to travel with swaps, especially,
 * if there is some small elements in the last indexes).
 * Every time we pass the array, we reduce the gap between sotted elements, when is one - it is done
 */
public class ShellSort<T extends Comparable<T>> implements Sort<T> {
    private List<T> result;
    private int currentIndex;
    private int previousIndex;

    @Override
    public List<T> sort(List<T> unsorted) {
        result = new ArrayList<>(unsorted);
        int gap = knuthSequenceIntervals(result.size());

        while (gap > 0) {
            sortWithStepUsedForShellSort(gap);
            gap = (gap - 1) / 3;
        }

        return result;
    }

    // generates number of intervals
    private int knuthSequenceIntervals(int intervalNoLargerThen) {
        int gap = 0;
        int finalPossibleGap = (intervalNoLargerThen -1) /3;
        while (gap <= finalPossibleGap) {
            gap = gap * 3 + 1;
        }
        return gap;
    }

    public List<T> sortWithStepUsedForShellSort(int step) {
        int size = result.size();
        for (int i = step; i < size; i++) {
            currentIndex = i;
            previousIndex = i - step;
            while (previousIndex >= 0 && isCurrentSmallerThanPrevious()) {
                Collections.swap(result, previousIndex, currentIndex);
                currentIndex -= step;
                previousIndex -= step;
            }
        }
        return result;
    }

    private boolean isCurrentSmallerThanPrevious() {
        return result.get(currentIndex).compareTo(result.get(previousIndex)) < 0;
    }
}
