package com.solovev.model;

import java.util.List;

/**
 * Interface that will define every search algorithm
 */
public interface Sort<T> {
    List<T> sort(List<T> unsorted);
}
