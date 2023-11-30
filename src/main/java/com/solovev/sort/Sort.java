package com.solovev.sort;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

/**
 * Interface that will define every search algorithm
 */
public interface Sort<T extends Comparable<T>> {
    List<T> sort(List<T> unsorted);
}
