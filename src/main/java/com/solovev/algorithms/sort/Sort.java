package com.solovev.algorithms.sort;

import java.util.List;

/**
 * Interface that will define every search algorithm
 */
public interface Sort<T extends Comparable<T>> {
    List<T> sort(List<T> unsorted);
}
