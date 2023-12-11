package com.solovev.algorithms;

import lombok.Data;

import java.lang.reflect.Array;
import java.util.*;

public class HeapAlgorithmForCreateAllPossiblePositionsInList {

    public static<T> Set<List<T>> getAllRecursivePermutations(List<T> elements) {
        List<T> elementsCopy = new ArrayList<>(elements);
        Set<List<T>> result = new HashSet<>();
        getAllRecursivePermutations(elements.size(),elementsCopy,result);
        return result;
    }

    private static <T> void getAllRecursivePermutations(int counter, List<T> elements,Collection<List<T>> result) {
        if (counter < 2) {
            result.add(List.copyOf(elements));
        } else {
            getAllRecursivePermutations(counter - 1, elements, result);
            for (int i = 0; i < counter-1; i++) {
                if (counter % 2 == 0) {
                    swapElements(elements,i, counter - 1);
                } else {
                    swapElements(elements,0, counter - 1);
                }
                getAllRecursivePermutations(counter -1, elements, result);
            }
        }
    }

    /**
     * MODIFIES ELEMENTS
     */
    private static <T> void swapElements(List<T> elements,int element1, int element2) {
        T tmp = elements.get(element1);
        elements.set(element1, elements.get(element2));
        elements.set(element2, tmp);
    }

}
