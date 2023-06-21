package com.solovev.model.sort;

import java.util.List;

/**
 * Interface that will define every search algorithm
 */
public interface Sort<T> {
    List<T> sort(List<T> unsorted);
}
