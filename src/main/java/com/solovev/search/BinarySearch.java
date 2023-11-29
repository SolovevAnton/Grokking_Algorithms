package com.solovev.search;

import java.util.List;

public class BinarySearch {
    /**
     * Binary searches for element in the arr
     *
     * @param arr   array to search in SHOULD BE SORTED
     * @param value to search in this array
     * @return index of the element or -1  if not found
     */
    public static <T extends Comparable<T>> int binarySearch(List<T> arr, T value) {

        int start = 0;
        int end = arr.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            T midElem = arr.get(mid);

            if (midElem.equals(value)) {
                return mid;
            } else if (midElem.compareTo(value) < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
