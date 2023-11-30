package com.solovev.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BubbleSort<T extends Comparable<T>> implements Sort<T> {
    private List<T> result;
    @Override
    public List<T> sort(List<T> unsorted) {
       result = new ArrayList<>(unsorted);
        int maxIndex = result.size() - 1;
        for (int i = maxIndex; i >= 0; i--) {
            boolean wasSwapped = false;
            for(int k = 0; k < i; k++){
                if(firstIsLarger(k,k+1)){
                    Collections.swap(result,k,k+1);
                   wasSwapped = true;
                }
            }
            if(!wasSwapped) {
                break;
            }
        }
        return result;
    }
    private boolean firstIsLarger(int indexOfElement1, int indexOfElement2){
        return result.get(indexOfElement1).compareTo(result.get(indexOfElement2)) > 0;
    }
}
