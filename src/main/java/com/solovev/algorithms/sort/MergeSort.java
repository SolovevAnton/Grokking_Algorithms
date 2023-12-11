package com.solovev.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public List<T> sort(List<T> unsorted) {
        if (unsorted.size() < 2) {
            return unsorted;
        } else {
            int midPoint = unsorted.size() / 2;
            List<T> sortedLeft = sort(unsorted.subList(0, midPoint));
            List<T> sortedRight = sort(unsorted.subList(midPoint, unsorted.size()));
            return merge(sortedLeft, sortedRight);
        }
    }

    private List<T> merge(List<T> left, List<T> right) {
        List<T> res = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while(leftIndex < left.size() && rightIndex < right.size()){
            if(leftSmallerThanRight(left.get(leftIndex),right.get(rightIndex))){
                res.add(left.get(leftIndex));
                leftIndex++;
            } else {
                res.add(right.get(rightIndex));
                rightIndex++;
            }
        }

        pushAllRemained(leftIndex,left,res);
        pushAllRemained(rightIndex,right,res);

        return res;
    }

    private boolean leftSmallerThanRight(T left, T right) {
        return left.compareTo(right) < 0;
    }
    private void pushAllRemained(int currentIndex, List<T> partList, List<T> resultList){
        while (currentIndex < partList.size()){
            resultList.add(partList.get(currentIndex));
            currentIndex++;
        }
    }
}

