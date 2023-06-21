package com.solovev.model;

import java.util.List;
import java.util.Optional;

public class OtherAlgorithms{
    /**
     * Binary searches for element in the arr
     * @param arr array to search in SHOULD BE SORTED
     * @param value to search in this array
     * @return Optional of value or empty optional if not found
     */
    public static Optional<Integer> binarySearch(List<Integer> arr, Integer value){
        if(arr.isEmpty()) {
            return Optional.empty();
        }
        int indexToLook = arr.size()/2;
        int elementToLook = arr.get(indexToLook);
        return Optional.empty();
    }
}
